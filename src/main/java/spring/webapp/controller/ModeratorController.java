package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.webapp.database.entity.AdminInfo;
import spring.webapp.database.entity.User;
import spring.webapp.database.entity.UserBalance;
import spring.webapp.database.entity.UserInfo;
import spring.webapp.database.repository.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class ModeratorController {
    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String phoneNumber;
    private String password;
    private String airline;
    @Autowired
    UserRepository ur;
    @Autowired
    UserInfoRepository usi;
    @Autowired
    AdminInfoRepository air;
    @Autowired
    UserBalanceRepository userbalance;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    BalanceTopUpRecordRepository recordRepository;


    @GetMapping("/moderatormenu")
    public String show(HttpServletRequest request){
        request.getSession().setAttribute("record",recordRepository.findAll());
        return "moderatorpage";
    }

    @GetMapping("/moderatormenu=manageuser")
    public String manageUser(Model model) {
        model.addAttribute("userinfolist", ur.findAll());
        return "moderatorpage";
    }

    @PostMapping("/moderatorinsert")
    public String registerAdmin(Model model,
                                @RequestParam(value="first_name") String firstName,
                                @RequestParam(value="last_name") String lastName,
                                @RequestParam(value="phone_number")String phoneNumber,
                                @RequestParam(value="email")String email,
                                @RequestParam(value="password")String password,
                                @RequestParam(value="dob")String dob,
                                @RequestParam(value="airline")String airline){
        setSession(model,firstName,lastName,email,dob,phoneNumber,password,airline);
        Map<String,String> tokens = paramsToMap();
        String errMessage = validate(tokens);
        if (!errMessage.equals("OK")) {
            model.addAttribute("error_message", errMessage);
            return "moderatorpage";
        }
        else {
            addUserToDatabase();
            return "moderatorpage";
        }

    }

    private void setSession(Model model, String firstName, String lastName, String email, String dob, String phoneNumber, String password,String airline) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.airline = airline;
        model.addAttribute("first_name", firstName);
        model.addAttribute("last_name", lastName);
        model.addAttribute("email", email);
        model.addAttribute("dob", dob);
        model.addAttribute("phone_number", phoneNumber);
        model.addAttribute("airline",airline);
    }
    private Map<String,String> paramsToMap() {
        Map<String,String> tokens = new LinkedHashMap<>();
        tokens.put("first_name", firstName);
        tokens.put("last_name", lastName);
        tokens.put("email", email);
        tokens.put("dob", dob);
        tokens.put("phone_number", phoneNumber);
        tokens.put("password", password);
        tokens.put("airline",airline);
        return tokens;
    }
    private String validate(Map<String,String> tokens) {
        for (Map.Entry<String, String> entry : tokens.entrySet()) {
            String token = entry.getValue();
            String tokenPrintable = entry.getKey();
            if (token == null || token.isEmpty()) return tokenPrintable + " is missing";
        }
        return "OK";
    }
    private void addUserToDatabase() {
        String hashedPassword = passwordEncoder.encode(password);
        ur.save(new User(email, hashedPassword, "admin"));
        Integer userID = ur.findOneByEmail(email).getId();
        usi.save(new UserInfo(userID, firstName, lastName, dob, phoneNumber));
        air.save(new AdminInfo(userID,airline));
        userbalance.save(new UserBalance(userID,0));
    }
}
