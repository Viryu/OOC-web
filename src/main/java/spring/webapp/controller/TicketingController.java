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
        Integer userID = ur.findOneByEmail(auth.getName()).getId();
        float pricetopay = Float.parseFloat(request.getParameter("pricetopay"));

        request.getSession().setAttribute("flightid",fdr.findFlightDetailByFlightid(flightid)); // the selected flight's flight detail
        request.getSession().setAttribute("userbalance",userbalance.findUserBalanceByUserid(userID).getBalance());
        request.getSession().setAttribute("pricetopay",pricetopay);

        // In case error message was set from a previous order
        request.getSession().removeAttribute("errMsg");

        return "checkoutpage";
    }
}
