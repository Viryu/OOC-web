package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.webapp.database.entity.BalanceTopUpRecord;
import spring.webapp.database.entity.UserBalance;
import spring.webapp.database.repository.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @GetMapping("/user")
    public String userpage(Authentication auth, HttpServletRequest request){
        Integer userID = ur.findOneByEmail(auth.getName()).getId();
        request.getSession().setAttribute("user",ur.findOneByEmail(auth.getName()));
        request.getSession().setAttribute("userbalance",ubr.findUserBalanceByUserid(userID));
        request.getSession().setAttribute("userinfo",uir.findUserInfoByUserid(userID));
        return "userpage";
    }
    @PostMapping("/inputbalance")
    public String balanceinput(HttpServletRequest request,Authentication auth,
            @RequestParam(value="inputamount")String balance){
        String time = getCurrentTime();
        Integer userID = ur.findOneByEmail(auth.getName()).getId();
        float balancef = Float.parseFloat(balance);
        float newamount = ubr.findUserBalanceByUserid(userID).getBalance() + balancef;
        ubr.save(new UserBalance(userID,newamount));
        btur.save(new BalanceTopUpRecord(userID,balancef,time));
        return "userpage";
    }

    public String getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
