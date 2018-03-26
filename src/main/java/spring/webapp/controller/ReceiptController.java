package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import spring.webapp.database.entity.FlightDetail;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.database.repository.TransactionRecordRepository;
import spring.webapp.database.repository.UserRepository;
import spring.webapp.specification.FlightDetailSpecification;
import spring.webapp.specification.SearchCriteria;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ReceiptController {
    @Autowired
    FlightDetailRepository fdr;
    @Autowired
    TransactionRecordRepository tr;
    @Autowired
    UserRepository ur;
    @GetMapping("/receipt")
    public String receipt(Authentication auth, HttpServletRequest request){
        Integer userID = ur.findOneByEmail(auth.getName()).getId();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        FlightDetailSpecification spec1 = new FlightDetailSpecification(new SearchCriteria("userid", ":", userID.toString()));
        FlightDetailSpecification spec2 = new FlightDetailSpecification(new SearchCriteria("transactiondate", ":",df.format(date)));
        request.getSession().setAttribute("flight",fdr.findAll(Specifications.where(spec1).and(spec2)));
        request.getSession().setAttribute("price",tr.findTransactionRecordByUserid(userID).getPricetopay());
        request.getSession().setAttribute("transaction",tr.findAll());
        return "receiptpage";
    }
}
