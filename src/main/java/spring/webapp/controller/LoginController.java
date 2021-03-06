package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request, Principal principal) {
        Object errorLogin = request.getSession().getAttribute("error_login");
        Object email = request.getSession().getAttribute("email");
        if (errorLogin != null) {
            model.addAttribute("error_login", errorLogin);
            request.getSession().removeAttribute("error_login");
        }
        if (email != null) {
            model.addAttribute("email", email);
            request.getSession().removeAttribute("email");
        }
        if (principal != null) {
            return "redirect:/";
        }
        return "login";
    }
}
