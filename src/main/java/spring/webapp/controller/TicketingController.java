package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.database.repository.UserBalanceRepository;
import spring.webapp.database.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TicketingController {
    @Autowired
    UserRepository ur;
    @Autowired
    UserBalanceRepository userbalance;
    @Autowired
    FlightDetailRepository fdr;
    @GetMapping("/ticket")
    public String view(){
        return "ticketpage";
    }
    @PostMapping("/checkout")
    public String getview(HttpServletRequest request, Authentication auth, Model model){
        Integer flightid = Integer.parseInt(request.getParameter("flightid"));
        Integer passengeramount = Integer.parseInt(request.getParameter("passengeramount"));

        Integer userID = ur.findOneByEmail(auth.getName()).getId();
        request.getSession().setAttribute("flightss",fdr.findFlightDetailByFlightid(flightid));
        request.getSession().setAttribute("userbalance",userbalance.findUserBalanceByUserid(userID).getBalance());
        float pricetopay = passengeramount * fdr.findFlightDetailByFlightid(flightid).getPrice();
        request.getSession().setAttribute("passengeramount",passengeramount);
        request.getSession().setAttribute("pricetopay",pricetopay);
        model.addAttribute("pricetopay",pricetopay);
        model.addAttribute("flightid",flightid);
        model.addAttribute("passengeramount",passengeramount);
        request.getSession().removeAttribute("errMsg");
        return "checkoutpage";
    }
}
