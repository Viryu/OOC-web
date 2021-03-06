package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.webapp.database.entity.User;
import spring.webapp.database.entity.UserBalance;
import spring.webapp.database.entity.UserInfo;
import spring.webapp.database.repository.UserBalanceRepository;
import spring.webapp.database.repository.UserInfoRepository;
import spring.webapp.database.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class RegisterController {
    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String phoneNumber;
    private String password;
    private String passwordConfirm;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserBalanceRepository userbalance;

    @GetMapping("/register")
    public String registerDefault() {
        return "register";
    }

    @PostMapping("/register=newuser")
    public String registerUser(Model model, HttpServletRequest request,
                                @RequestParam(value = "first_name") String firstName,
                                @RequestParam(value = "last_name") String lastName,
                                @RequestParam(value = "email") String email,
                                @RequestParam(value = "dob") String dob,
                                @RequestParam(value = "phone_number") String phoneNumber,
                                @RequestParam(value = "password") String password,
                                @RequestParam(value = "password_confirmation") String passwordConfirm) {
        setSession(model, firstName, lastName, email, dob, phoneNumber, password, passwordConfirm);
        Map<String,String> tokens = paramsToMap();
        String errorMessage = validate(tokens);
        if (!errorMessage.equals("OK")) {
            model.addAttribute("error_register", errorMessage);
            return "register";
        }
        else {
            addUserToDatabase();
            loginWithAuthManager(request, email, password);
            return "redirect:/";
        }
    }

    private void setSession(Model model, String firstName, String lastName, String email, String dob, String phoneNumber, String password, String passwordConfirm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        model.addAttribute("first_name", firstName);
        model.addAttribute("last_name", lastName);
        model.addAttribute("email", email);
        model.addAttribute("dob", dob);
        model.addAttribute("phone_number", phoneNumber);
    }

    private Map<String,String> paramsToMap() {
        Map<String,String> tokens = new LinkedHashMap<>();
        tokens.put("First name", firstName);
        tokens.put("Last name", lastName);
        tokens.put("Email", email);
        tokens.put("Date of birth", dob);
        tokens.put("Phone number", phoneNumber);
        tokens.put("Password", password);
        tokens.put("Password Confirm", passwordConfirm);
        return tokens;
    }

    private String validate(Map<String,String> tokens) {
        for (Map.Entry<String, String> entry : tokens.entrySet()) {
            String token = entry.getValue();
            String tokenPrintable = entry.getKey();
            if (token == null || token.isEmpty()) return tokenPrintable + " is missing";
        }
        try {
            Long.parseLong(tokens.get("Phone number").trim());
        } catch(NumberFormatException e) {
            return "Phone numbers must contain only numbers";
        }
            if (!tokens.get("Password").equals(tokens.get("Password Confirm"))) return "Password does not match confirm password";
        return "OK";
    }

    private void addUserToDatabase() {
        String hashedPassword = passwordEncoder.encode(password);
        userRepository.save(new User(email, hashedPassword, "customer"));
        Integer userID = userRepository.findOneByEmail(email).getId();
        userInfoRepository.save(new UserInfo(userID, firstName, lastName, dob, phoneNumber));
        userbalance.save(new UserBalance(userID,0));
    }

    private void loginWithAuthManager(HttpServletRequest request, String username, String password) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        authToken.setDetails(new WebAuthenticationDetails(request));
        Authentication authentication = authenticationManager.authenticate(authToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @ExceptionHandler({SQLException.class,DataIntegrityViolationException.class})
    private String duplicateEmail(Model model) {
        model.addAttribute("error_register", "Email is already in used");
        return "register";
    }
}
