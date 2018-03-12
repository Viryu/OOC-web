package spring.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @RequestParam(value="name", required=false, defaultValue="Customer") String name) {
        // Use via http://localhost:8080/login?name=[put_name_here]
        model.addAttribute("name", name);
        return "homepage";
    }
}
