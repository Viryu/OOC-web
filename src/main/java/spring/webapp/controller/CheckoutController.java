package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import spring.webapp.database.entity.FlightDetail;
import spring.webapp.database.entity.TransactionRecord;
import spring.webapp.database.entity.UserBalance;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.database.repository.TransactionRecordRepository;
import spring.webapp.database.repository.UserBalanceRepository;
import spring.webapp.database.repository.UserRepository;
import spring.webapp.payment.Balance;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    WebApplicationContext context;
    String passengername;
    String idnumber;
    String namePrefix;
    String idtype;
    String bookingcode;
    String errMsg;

    @GetMapping("/checkout")
    public String getview(){
        return "checkoutpage";
    }

    @PostMapping("/checkout=topup")
    public String topUp(HttpServletRequest request,
                        @RequestParam(value="inputamount") String amount) {
        Balance balance = (Balance) context.getBean("balance");
        float newBalance = balance.topUp(Float.parseFloat(amount));
        request.getSession().setAttribute("userbalance", newBalance);
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
        model.addAttribute("pricetopay");
        model.addAttribute("flightid");
        model.addAttribute("userid");
        System.out.println(request.getParameter("passengeramount"));
        Integer passengeramount = Integer.parseInt(request.getParameter("passengeramount"));
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Integer userID = ur.findOneByEmail(auth.getName()).getId();
        Integer flightid = Integer.parseInt(request.getParameter("flightid"));
        float price = Float.parseFloat(request.getParameter("pricetopay"));
        FlightDetail flightDetail = new FlightDetail();
        flightDetail.setFlightid(flightid);
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
        float newbalance = userbalance.findUserBalanceByUserid(userID).getBalance()-price;
        if(userbalance.findUserBalanceByUserid(userID).getBalance()<price){
            errMsg = "Not enough balance";
            request.getSession().setAttribute("errMsg",errMsg);
            return "checkoutpage";
        }
        else{
            for (int i =0;i<passengeramount;i++){
                tr.save(new TransactionRecord(df.format(date),userID,fdr.findFlightDetailByFlightid(flightid).getFlightno(),namePrefixes.get(i),passengernames.get(i),bookingcode,idnumbers.get(i),idtypes.get(i),price));
            }
            userbalance.save(new UserBalance(userID,newbalance));
            fdr.save(flightDetail);
            return "redirect:/userReceipt";
        }
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
