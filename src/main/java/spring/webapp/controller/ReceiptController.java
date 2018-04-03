package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.webapp.database.entity.FlightDetail;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.database.repository.TransactionRecordRepository;
import spring.webapp.database.repository.UserRepository;
import spring.webapp.specification.FlightDetailSpecification;
import spring.webapp.specification.SearchCriteria;
import spring.webapp.specification.TransactionRecordSpecification;

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
    @GetMapping("/receiptdetail")
    public String receiptdetail(HttpServletRequest request){
        String bookingcode = request.getParameter("bookingcode");
        request.getSession().setAttribute("bookingcode",bookingcode);
        System.out.println(bookingcode);
        return "receiptpage";
    }
}
