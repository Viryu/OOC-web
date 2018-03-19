package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.webapp.database.Entity.User;
import spring.webapp.database.Entity.UserInfo;
import spring.webapp.database.Repository.UserRepository;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class LoginController {
//    @Autowired
//    UserRepository userRe;
//    User user;
    String email;
    String password;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login=new")
    public String loginmember(Model model){
//                              @RequestParam(value="email") String email,
//                              @RequestParam(value="password") String password){
//      user = userRe.findOneByEmail(email);
//      user = userRe.findOneByPassword(password);
//      setSession(model,email,password);
//      Map<String,String> tokens = paramsToMap();
//      String errMsg = validate(tokens);
//      if(errMsg!=("OK")){
//          model.addAttribute("errMsg",errMsg);
          return "login";
      }
//      else{
//        return "redirect:/";
//      }
//    }
//    private void setSession(Model model, String email,String password) {
//        this.email = email;
//        this.password = password;
//        model.addAttribute("email", email);
//        model.addAttribute("password",password);
//    }
//    private Map<String,String> paramsToMap() {
//        Map<String,String> tokens = new LinkedHashMap<>();
//        tokens.put("email", email);
//        tokens.put("password", password);
//        return tokens;
//    }
//    private String validate(Map<String,String> tokens) {
//        for (Map.Entry<String, String> entry : tokens.entrySet()) {
//            String token = entry.getValue();
//            String tokenPrintable = entry.getKey();
//            if (token == null || token.isEmpty()) return tokenPrintable + " is missing";
//        }
//        if(!tokens.get("password").equals(userRe.findOneByPassword(password))){
//            return "Wrong Password";
//        }
//        return "OK";
//    }
}
