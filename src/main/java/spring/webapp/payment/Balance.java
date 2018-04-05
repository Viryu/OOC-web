package spring.webapp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import spring.webapp.database.entity.BalanceTopUpRecord;
import spring.webapp.database.entity.UserBalance;
import spring.webapp.database.repository.BalanceTopUpRecordRepository;
import spring.webapp.database.repository.UserBalanceRepository;
import spring.webapp.database.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Scope("prototype")
public class Balance {
    @Autowired
    UserRepository ur;
    @Autowired
    UserBalanceRepository ubr;
    @Autowired
    BalanceTopUpRecordRepository btur;

    private Integer userID;

    @PostConstruct
    public void balanceInit() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        userID = ur.findOneByEmail(auth.getName()).getId();
    }

    public float topUp(float amount) {
        float newBalance = ubr.findUserBalanceByUserid(userID).getBalance() + amount;
        ubr.save(new UserBalance(userID, newBalance));
        btur.save(new BalanceTopUpRecord(userID, amount, getCurrentTime()));
        return newBalance;
    }

    private String getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
