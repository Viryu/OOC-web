package spring.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReceiptController {
    @GetMapping("/receipt")
    public String receipt(){
        return "receiptpage";
    }
}
