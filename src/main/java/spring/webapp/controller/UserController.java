package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import spring.webapp.database.entity.User;
import spring.webapp.database.entity.UserInfo;
import spring.webapp.database.repository.BalanceTopUpRecordRepository;
import spring.webapp.database.repository.UserBalanceRepository;
import spring.webapp.database.repository.UserInfoRepository;
import spring.webapp.database.repository.UserRepository;
import spring.webapp.payment.Balance;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    UserInfoRepository uir;
    @Autowired
    UserRepository ur;
    @Autowired
    UserBalanceRepository ubr;
    @Autowired
    BalanceTopUpRecordRepository btur;
    @Autowired
    WebApplicationContext context;

    @GetMapping("/user")
    public String userpage(Authentication auth, HttpServletRequest request) {
        User user = ur.findOneByEmail(auth.getName());
        Integer userID = user.getId();
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("userbalance",ubr.findUserBalanceByUserid(userID));
        request.getSession().setAttribute("userinfo",uir.findUserInfoByUserid(userID));
        return "userpage";
    }
    @PostMapping("/inputbalance")
    public String balanceinput(HttpServletRequest request,
            @RequestParam(value="inputamount")String amount){
        Balance balance = (Balance) context.getBean("balance");
        balance.topUp(Float.parseFloat(amount));
        return "redirect:/user";
    }

    @PostMapping("/user=updateinfo")
    public String updateInfo (Authentication auth,
                               @RequestParam(value = "firstNameUpdate") String firstName,
                               @RequestParam(value = "lastNameUpdate") String lastName,
                               @RequestParam(value = "dobUpdate") String dob,
                               @RequestParam(value = "phoneNumberUpdate") String phoneNumber) {
        UserInfo newUserInfo = updateCurrentUserInfo(auth.getName(), firstName, lastName, dob, phoneNumber);
        uir.save(newUserInfo);
        return "redirect:/user";
    }

    private UserInfo updateCurrentUserInfo(String email, String firstName, String lastName, String dob, String phoneNumber) {
        // TODO: Could be optimized by retrieving the value from session instead
        User user = ur.findOneByEmail(email);
        Integer userID = user.getId();
        UserInfo userInfo = uir.findUserInfoByUserid(userID);
        userInfo.setFirstName(firstName);
        userInfo.setLastName(lastName);
        userInfo.setDob(dob);
        userInfo.setPhoneNumber(phoneNumber);
        return userInfo;
    }



}
