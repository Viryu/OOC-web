package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.webapp.database.entity.FlightDetail;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.database.repository.UserBalanceRepository;
import spring.webapp.database.repository.UserRepository;
import spring.webapp.specification.FlightDetailSpecification;
import spring.webapp.specification.SearchCriteria;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CheckoutController {
    @Autowired
    FlightDetailRepository fdr;
    @Autowired
    UserBalanceRepository userbalance;
    @Autowired
    UserRepository ur;
    @PostMapping("/checkout")
    public String viewcheckout(HttpServletRequest request,Authentication auth){
        Integer idflight= Integer.parseInt(request.getParameter("flightid"));
        Integer userID = ur.findOneByEmail(auth.getName()).getId();
        request.getSession().setAttribute("flightss",fdr.findFlightDetailByFlightid(idflight));
        request.getSession().setAttribute("userbalance",userbalance.findUserBalanceByUserid(userID).getBalance());
        Integer passengeramount = Integer.parseInt(request.getParameter("passengeramount"));
        Integer startcounting = 1;
        float pricetopay = passengeramount * fdr.findFlightDetailByFlightid(idflight).getPrice();
        request.getSession().setAttribute("passengeramount",passengeramount);
        request.getSession().setAttribute("pricetopay",pricetopay);
        request.getSession().setAttribute("startcounting",startcounting);
        return "checkoutpage";
    }
}
