package spring.webapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, Authentication authentication) {
        if (authentication != null) {
            System.out.print(authentication.getName() + " ");
            for (GrantedAuthority auth : authentication.getAuthorities()) System.out.println(auth);
        }
        else System.out.println("Not logged in");
        return "homepage";
    }
}
