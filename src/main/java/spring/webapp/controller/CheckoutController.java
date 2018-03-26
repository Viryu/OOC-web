package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.webapp.database.entity.*;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.database.repository.TransactionRecordRepository;
import spring.webapp.database.repository.UserBalanceRepository;
import spring.webapp.database.repository.UserRepository;
import spring.webapp.specification.FlightDetailSpecification;
import spring.webapp.specification.SearchCriteria;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class CheckoutController {
    @Autowired
    FlightDetailRepository fdr;
    @Autowired
    UserBalanceRepository userbalance;
    @Autowired
    UserRepository ur;
    @Autowired
    TransactionRecordRepository tr;
    String passengername;
    String idnumber;
    String namePrefix;
    String idtype;
    String bookingcode;

    @GetMapping("/checkout")
    public String getview(){
        return "checkoutpage";
    }
    @PostMapping("/receipt")
    public String viewcheckout(HttpServletRequest request,Authentication auth, Model model,
                               @RequestParam(value="namePrefix[]")String[] namePrefix,
                               @RequestParam(value="passengername[]")String[] passengername,
                               @RequestParam(value ="idtype[]" )String[] idtype,
                               @RequestParam(value="idnumber[]")String[] idnumber){
        for (int i=0;i<passengername.length;i++){
            setSession(model,passengername[i],idnumber[i],namePrefix[i],idtype[i]);
        }
        System.out.println(request.getParameter("passengeramount"));
        Integer passengeramount = Integer.parseInt(request.getParameter("passengeramount"));
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Integer userID = ur.findOneByEmail(auth.getName()).getId();
        Integer flightid = Integer.parseInt(request.getParameter("flightid"));
        FlightDetail flightDetail = new FlightDetail();
        flightDetail.setStartdestination(fdr.findFlightDetailByFlightid(flightid).getStartdestination());
        flightDetail.setEnddestination(fdr.findFlightDetailByFlightid(flightid).getEnddestination());
        flightDetail.setDeparturedate(fdr.findFlightDetailByFlightid(flightid).getDeparturedate());
        flightDetail.setDeparturetime(fdr.findFlightDetailByFlightid(flightid).getDeparturetime());
        flightDetail.setArrivaldate(fdr.findFlightDetailByFlightid(flightid).getArrivaldate());
        flightDetail.setArrivaltime(fdr.findFlightDetailByFlightid(flightid).getArrivaltime());
        flightDetail.setSeatleft(fdr.findFlightDetailByFlightid(flightid).getSeatleft()-passengeramount);
        flightDetail.setSeatmax(fdr.findFlightDetailByFlightid(flightid).getSeatmax());
        flightDetail.setAirline(fdr.findFlightDetailByFlightid(flightid).getAirline());
        flightDetail.setFlightno(fdr.findFlightDetailByFlightid(flightid).getFlightno());
        flightDetail.setPrice(fdr.findFlightDetailByFlightid(flightid).getPrice());
        bookingcode = bookingcoderandom();
        for (int i =0;i<passengernames.size();i++){
            tr.save(new TransactionRecord(df.format(date),userID,fdr.findFlightDetailByFlightid(flightid).getFlightno(),namePrefixes.get(i),passengernames.get(i),idnumbers.get(i),idtypes.get(i),bookingcode));

        }
        fdr.save(flightDetail);
        System.out.println(bookingcode);
        return "receiptpage";
    }
    ArrayList<String> passengernames = new ArrayList<>() ;
    ArrayList<String> idnumbers = new ArrayList<>();
    ArrayList<String> namePrefixes = new ArrayList<>();
    ArrayList<String> idtypes = new ArrayList<>();
    private void setSession(Model model,String passengername,String idnumber,String namePrefix,String idtype) {
        this.namePrefixes.add(namePrefix);
        this.passengernames.add(passengername);
        this.idnumbers.add(idnumber);
        this.idtypes.add(idtype);

        model.addAttribute("passengername", passengername);
        model.addAttribute("idnumber", idnumber);
        model.addAttribute("namePrefix", namePrefix);
        model.addAttribute("idtype", idtype);

    }
    private String bookingcoderandom(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
