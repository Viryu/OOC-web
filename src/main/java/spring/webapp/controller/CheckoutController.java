package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.webapp.database.entity.FlightDetail;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.database.repository.UserBalanceRepository;
import spring.webapp.database.repository.UserRepository;
import spring.webapp.specification.FlightDetailSpecification;
import spring.webapp.specification.SearchCriteria;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CheckoutController {
    @Autowired
    FlightDetailRepository fdr;
    @Autowired
    UserBalanceRepository userbalance;
    @Autowired
    UserRepository ur;
    String passengername;
    String idnumber;
    @GetMapping("/checkout")
    public String getview(){
        return "checkoutpage";
    }
    @PostMapping("/receipt")
    public String viewcheckout(HttpServletRequest request,Authentication auth, Model model,
                               @RequestParam(value="passengername")String passengername,
                               @RequestParam(value="idnumber")String idnumber){
        setSession(model,passengername,idnumber);
        return "receiptpage";
    }
    List<String> passengernames;
    List<String> idnumbers;
    private void setSession(Model model,String passengername,String idnumber) {
        passengernames = new ArrayList<>();
        this.passengername = passengername;
        this.idnumber = idnumber;
        model.addAttribute("passengername", passengername);
        model.addAttribute("idnumber", idnumber);
//        for(int i=1;i<=passengeramount;i++){
//            String name = passengername+i;
//            String id = idnumber+i;


//            passengernames.add(name);
//            idnumbers.add(id);
//        }
    }
}
