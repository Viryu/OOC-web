package spring.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, Principal principal) {
        if (principal != null) System.out.println(principal.getName());
        else System.out.println("Not logged in");
        return "homepage";
    }
}
