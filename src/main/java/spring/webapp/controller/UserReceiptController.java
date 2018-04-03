package spring.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UserReceiptController {
    @GetMapping("/userReceipt")
    public String userReceipt(){
        return "userreceipt";
    }
}
