package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import spring.webapp.database.entity.FlightDetail;
import spring.webapp.database.entity.TransactionRecord;
import spring.webapp.database.entity.UserBalance;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.database.repository.TransactionRecordRepository;
import spring.webapp.database.repository.UserBalanceRepository;
import spring.webapp.database.repository.UserRepository;
import spring.webapp.payment.Balance;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class CheckoutController {
    @Autowired
    FlightDetailRepository fdr;
    @Autowired
    UserBalanceRepository userbalance;
    @Autowired
    UserRepository ur;
    @Autowired
    TransactionRecordRepository tr;
    @Autowired
    WebApplicationContext context;

    @GetMapping("/checkout")
    public String getview(){
        return "checkoutpage";
    }

    @PostMapping("/checkout=topup")
    public String topUp(HttpServletRequest request,
                        @RequestParam(value="inputamount") String amount) {
        Balance balance = (Balance) context.getBean("balance");
        float newBalance = balance.topUp(Float.parseFloat(amount));
        request.getSession().setAttribute("userbalance", newBalance);
        return "checkoutpage";
    }

    @PostMapping("/receipt")
    public String viewcheckout(HttpServletRequest request,Authentication auth, Model model,
                               @RequestParam(value="namePrefix[]")String[] namePrefixes,
                               @RequestParam(value="passengername[]")String[] passengernames,
                               @RequestParam(value ="idtype[]" )String[] idtypes,
                               @RequestParam(value="idnumber[]")String[] idnumbers){
        FlightDetail flightDetail =  (FlightDetail) request.getSession().getAttribute("flightid");
        Integer userID = ur.findOneByEmail(auth.getName()).getId();
        float currentbalance = userbalance.findUserBalanceByUserid(userID).getBalance();
        float price = (float) request.getSession().getAttribute("pricetopay");

        if (userbalance.findUserBalanceByUserid(userID).getBalance() < price) {
            String errMsg = "Not enough balance";
            request.getSession().setAttribute("errMsg",errMsg);
            return "checkoutpage";
        }
        else {
            String bookingcode = bookingcoderandom();
            Integer passengeramount = (Integer) request.getSession().getAttribute("passengeramount");
            float newbalance = currentbalance - price;
            userbalance.save(new UserBalance(userID,newbalance));
            for (int i = 0; i<passengeramount; i++) {
                tr.save(new TransactionRecord(getCurrentTime(), userID, flightDetail.getFlightno(),namePrefixes[i],passengernames[i],bookingcode,idnumbers[i],idtypes[i],price));
            }
            flightDetail.setSeatleft(flightDetail.getSeatleft() - passengeramount);
            fdr.save(flightDetail);
            return "redirect:/userReceipt";
        }
    }

    private String getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String bookingcoderandom(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (true) {
            while (salt.length() < 6) { // length of the random string.
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            String saltStr = salt.toString();
            if (tr.findTransactionRecordByBookingcode(saltStr) == null) return saltStr;
        }
    }
}
