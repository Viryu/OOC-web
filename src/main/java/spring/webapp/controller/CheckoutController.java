package spring.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckoutController {
    @GetMapping("/checkout")
    public String checkout(@RequestParam("flightID") Integer flightID){
        System.out.println(flightID);
        return "checkoutpage";
    }
}
