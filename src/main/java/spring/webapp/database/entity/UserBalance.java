package spring.webapp.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserBalance {
    @Id
    private Integer userid;
    @Column
    private float balance;

    public Integer getUserid() {
        return userid;
    }

    protected UserBalance(){}
    public UserBalance(Integer userid, float balance) {
        this.userid = userid;
        this.balance = balance;
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
}
