package spring.webapp.controller;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.database.entity.FlightDetail;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    FlightDetailRepository fdr;
    private String destination;
    private String startdestination;
    private String dod;
    private String seats;
    private String hours;
    private String minutes;

    @GetMapping("/adminpage")
    public String show(){
        return "adminpage";
    }

    @GetMapping("/adminpage=showflight")
    public String showflight(HttpServletRequest request){
        request.getSession().setAttribute("flights",fdr.findAll());
        return "adminpage";
    }




    @PostMapping("/admininsert")
    public String registerAdmin(Model model,
                                @RequestParam(value="startdestination")String start,
                                @RequestParam(value="destination") String destination,
                                @RequestParam(value="dod")String dod,
                                @RequestParam(value="seats")String seats,
                                @RequestParam(value="hours")String hours,
                                @RequestParam(value="minutes")String minutes){
        setSession(model,destination,start,seats,dod,hours,minutes);
        FlightDetail flightDetail = new FlightDetail();
        Map<String,String> tokens = paramsToMap();
        String errMessage = validate(tokens);
        if (!errMessage.equals("OK")) {
            model.addAttribute("error_message", errMessage);
            return "adminpage";
        }
        else {
            addUserToDatabase();
            return "adminpage";
        }

    }
    private void setSession(Model model, String startdestination,String enddestination,String departuredate, String departuretime,String arrivaldate, String arrivaltime, String seatleft,String airline, String flightno, float price) {
        this.startdestination = startdestination;
        this.enddestination = enddestination;
        this.departuredate = departuredate;
        this.departuretime = departuretime;
        this.arrivaldate = arrivaldate;
        this.arrivaltime = arrivaltime;
        this.seatleft = seatleft;
        this.
        model.addAttribute("destination", destination);
        model.addAttribute("startdestination", startdestination);
        model.addAttribute("seats", seats);
        model.addAttribute("dod", dod);
        model.addAttribute("hours",hours);
        model.addAttribute("minutes",minutes);
    }
    private Map<String,String> paramsToMap() {
        Map<String,String> tokens = new LinkedHashMap<>();
        tokens.put("destination", destination);
        tokens.put("startdestination", startdestination);
        tokens.put("dod", dod);
        tokens.put("seats", seats);
        tokens.put("hours",hours);
        tokens.put("minutes",minutes);
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

    private void addUserToDatabase() {
        int seat;
        seat = Integer.parseInt(seats);
        fdr.save(new FlightDetail(destination,startdestination,dod,seat,hours,minutes));
    }
}
