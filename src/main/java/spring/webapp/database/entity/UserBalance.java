package spring.webapp.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserBalance {
    @Id
    private Integer userid;
    @Column
    private Integer balance;

    public Integer getUserid() {
        return userid;
    }

    protected UserBalance(){}
    public UserBalance(Integer userid, Integer balance) {
        this.userid = userid;
        this.balance = balance;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
