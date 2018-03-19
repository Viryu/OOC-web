package spring.webapp.controller;

import org.joda.time.DateTimeZone;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.webapp.database.Entity.User;
import spring.webapp.database.Entity.UserInfo;
import spring.webapp.database.Repository.UserInfoRepository;
import spring.webapp.database.Repository.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Controller
public class ModeratorController {
    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String phoneNumber;
    private String password;
    @Autowired
    UserRepository ur;
    @Autowired
    UserInfoRepository usi;
    @GetMapping("/moderatormenu")
    public String show(Map<String,Object> model){
        return "moderatorpage";
    }
    @PostMapping("/moderatorinsert")
    public String registerAdmin(Model model,
                                @RequestParam(value="first_name") String firstName,
                                @RequestParam(value="last_name") String lastName,
                                @RequestParam(value="phone_number")String phoneNumber,
                                @RequestParam(value="email")String email,
                                @RequestParam(value="password")String password,
                                @RequestParam(value="dob")String dob){
        for (User user :  ur.findAll()) {
            System.out.println("Begin of list");
            System.out.println(user.getEmail());
        }
        model.addAttribute("userinfolist", ur.findAll());
        //System.out.println(ur.findOneByEmail("test1@email.com"));
        setSession(model,firstName,lastName,email,dob,phoneNumber,password);
        Map<String,String> tokens = paramsToMap();
        String errMessage = validate(tokens);
        if (!errMessage.equals("OK")) {
            model.addAttribute("error_message", errMessage);
            return "moderatormenu";
        }
        else {
            addUserToDatabase();
            return "redirect:/moderatormenu";
        }

    }

    private void setSession(Model model, String firstName, String lastName, String email, String dob, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.password = password;
        model.addAttribute("first_name", firstName);
        model.addAttribute("last_name", lastName);
        model.addAttribute("email", email);
        model.addAttribute("dob", dob);
        model.addAttribute("phone_number", phoneNumber);
    }
    private Map<String,String> paramsToMap() {
        Map<String,String> tokens = new LinkedHashMap<>();
        tokens.put("first_name", firstName);
        tokens.put("last_name", lastName);
        tokens.put("email", email);
        tokens.put("dob", dob);
        tokens.put("phone_number", phoneNumber);
        tokens.put("password", password);
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
        ur.save(new User(email, password, "admin"));
        Integer userID = ur.findOneByEmail(email).getId();
        usi.save(new UserInfo(userID, firstName, lastName, dob, phoneNumber));
    }
}
