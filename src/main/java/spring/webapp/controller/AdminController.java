package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.webapp.database.entity.FlightDetail;
import spring.webapp.database.entity.User;
import spring.webapp.database.repository.AdminInfoRepository;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.database.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    FlightDetailRepository fdr;
    @Autowired
    AdminInfoRepository air;
    @Autowired
    UserRepository ur;
    private String startdestination;
    private String enddestination;
    private String departuredate;
    private String departuretime;
    private String arrivaldate;
    private String arrivaltime;
    private String seatleft;
    private String seatmax;
    private String airline = null;
    private String flightno;
    private String price;

    @GetMapping("/adminpage")
    public String show(HttpServletRequest request, Authentication auth) {
        if (airline == null) {
            Integer userID = ur.findOneByEmail(auth.getName()).getId();
            request.getSession().setAttribute("airline", air.findAdminInfoByAdminID(userID).getAirline());
        }
        String airline = (String)request.getSession().getAttribute("airline");
        request.getSession().setAttribute("flights",fdr.findAllByAirline(airline));
        return "adminpage";
    }

    @PostMapping("/admininsert")
    public String registerAdmin(Model model,
                                @RequestParam(value="startdestination")String startdestination,
                                @RequestParam(value="enddestination") String enddestination,
                                @RequestParam(value="departuredate")String departuredate,
                                @RequestParam(value="departuretime")String departuretime,
                                @RequestParam(value="arrivaldate")String arrivaldate,
                                @RequestParam(value="arrivaltime")String arrivaltime,
                                @RequestParam(value="seatleft")String seatleft,
                                @RequestParam(value="airline")String airline,
                                @RequestParam(value="flightno")String flightno,
                                @RequestParam(value="price")String price){
        setSession(model,startdestination,enddestination,departuredate,departuretime,arrivaldate,arrivaltime,seatleft,airline,flightno,price);
        int seat;
        seat = Integer.parseInt(seatleft);
        float flightprice;
        flightprice = Float.parseFloat(price);
        FlightDetail flightDetail = new FlightDetail();
        flightDetail.setStartdestination(startdestination);
        flightDetail.setEnddestination(enddestination);
        flightDetail.setDeparturedate(departuredate);
        flightDetail.setDeparturetime(departuretime);
        flightDetail.setArrivaldate(arrivaldate);
        flightDetail.setArrivaltime(arrivaltime);
        flightDetail.setSeatleft(seat);
        flightDetail.setSeatmax(seat);
        flightDetail.setAirline(airline);
        flightDetail.setFlightno(flightno);
        flightDetail.setPrice(flightprice);
        Map<String,String> tokens = paramsToMap();
        String errMessage = validate(tokens);
        if (!errMessage.equals("OK")) {
            model.addAttribute("error_message", errMessage);
            return "adminpage";
        }
        else {
            fdr.save(flightDetail);
            return "adminpage";
        }

    }
    private void setSession(Model model, String startdestination,String enddestination,String departuredate, String departuretime,String arrivaldate, String arrivaltime, String seatleft,String airline, String flightno, String price) {
        this.startdestination = startdestination;
        this.enddestination = enddestination;
        this.departuredate = departuredate;
        this.departuretime = departuretime;
        this.arrivaldate = arrivaldate;
        this.arrivaltime = arrivaltime;
        this.seatleft = seatleft;
        this.seatmax = seatleft;
        this.airline = airline;
        this.flightno = flightno;
        this.price = price;
        model.addAttribute("startdestination", startdestination);
        model.addAttribute("enddestination", enddestination);
        model.addAttribute("departuredate", departuredate);
        model.addAttribute("departuretime", departuretime);
        model.addAttribute("arrivaldate",arrivaldate);
        model.addAttribute("arrivaltime",arrivaltime);
        model.addAttribute("seatleft",seatleft);
        model.addAttribute("airline",airline);
        model.addAttribute("flightno",flightno);
        model.addAttribute("price",price);
    }
    private Map<String,String> paramsToMap() {
        Map<String,String> tokens = new LinkedHashMap<>();
        tokens.put("startdestination", startdestination);
        tokens.put("enddestination", enddestination);
        tokens.put("departuredate", departuredate);
        tokens.put("departuretime", departuretime);
        tokens.put("arrivaldate",arrivaldate);
        tokens.put("arrivaltime",arrivaltime);
        tokens.put("seatleft",seatleft);
        tokens.put("airline",airline);
        tokens.put("flightno",flightno);
        tokens.put("price",price);
        return tokens;
    }
    private String validate(Map<String,String> tokens) {
        for (Map.Entry<String, String> entry : tokens.entrySet()) {
            String token = entry.getValue();
            String tokenPrintable = entry.getKey();
            if (token == null || token.isEmpty()) return tokenPrintable + " is missing";
        }
        try {
        } catch(NumberFormatException e) {
        }
        return "OK";
    }
}
