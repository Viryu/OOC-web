package spring.webapp.database.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BalanceTopUpRecord {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer recordnumber;
    @Column
    private Integer userid;
    @Column
    private float balance;
    @Column(columnDefinition = "date")
    private String transactiondate;

    public BalanceTopUpRecord(Integer userid, float balance, String transactiondate) {
        this.userid = userid;
        this.balance = balance;
        this.transactiondate = transactiondate;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(String transactiondate) {
        this.transactiondate = transactiondate;
    }
    protected BalanceTopUpRecord(){}
}
