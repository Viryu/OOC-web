package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.webapp.database.entity.FlightDetail;
import spring.webapp.database.entity.TransactionRecord;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.database.repository.TransactionRecordRepository;
import spring.webapp.database.repository.UserRepository;
import spring.webapp.specification.SearchCriteria;
import spring.webapp.specification.TransactionRecordSpecification;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserReceiptController {
    @Autowired
    TransactionRecordRepository tr;
    @Autowired
    UserRepository ur;
    @Autowired
    FlightDetailRepository fdr;
    @GetMapping("/userReceipt")
    public String receipt(Authentication auth, HttpServletRequest request, Model model){
        Integer userID = ur.findOneByEmail(auth.getName()).getId();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        TransactionRecordSpecification spec1 = new TransactionRecordSpecification(new SearchCriteria("userid", ":", userID.toString()));
        TransactionRecordSpecification spec2 = new TransactionRecordSpecification(new SearchCriteria("transactiondate", ":",df.format(date)));
        // TODO: Breakdown TransactionRecord to smaller tables
        List<TransactionRecord> trRecords = tr.findAll(spec1);
        List<TransactionRecord> uniqueTrRecords = transactionListOnlyUniqueBookingID(trRecords);
        request.getSession().setAttribute("flight",uniqueTrRecords);
        model.addAttribute("bookingcode");
        model.addAttribute("flightno");
        return "userreceipt";
    }

    // This function is a workaround for the current implementation of how TransactionRecord table work
    private List<TransactionRecord> transactionListOnlyUniqueBookingID (List<TransactionRecord> trList) {
        HashMap<String, TransactionRecord> trMap =  new HashMap<>();
        for (TransactionRecord tr : trList) trMap.putIfAbsent(tr.getBookingcode(), tr);
        return new ArrayList(trMap.values());
    }

    @PostMapping("/receiptdetail")
    public String toreceiptdetail(Authentication auth, HttpServletRequest request, Model model,
                                  @RequestParam(value="bookingcode") String bookingcode){
        Integer userID = ur.findOneByEmail(auth.getName()).getId();
        TransactionRecordSpecification spec1 = new TransactionRecordSpecification(new SearchCriteria("userid", ":", userID.toString()));
        TransactionRecordSpecification spec2 = new TransactionRecordSpecification(new SearchCriteria("bookingcode",":",bookingcode));
        List<TransactionRecord> transactionlist =
                tr.findAll(spec2);
        String flightno = request.getParameter("flightno");
        request.getSession().setAttribute("flight",fdr.findFlightDetailByFlightno(flightno));
        request.getSession().setAttribute("flights",transactionlist.get(0));
        request.getSession().setAttribute("passenger",transactionlist);
        model.addAttribute("bookingcode",request.getParameter("bookingcode"));
        return "receiptpage";
    }
}
