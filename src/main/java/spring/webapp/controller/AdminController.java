package spring.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @GetMapping("/adminpage")
    public String show(){
        return "adminpage";
    }
    @GetMapping("/adminpage=showflight")
    public String showflight(Model model){
        return "adminpage";
    }
}
