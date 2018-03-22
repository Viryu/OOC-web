package spring.webapp.database.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="TransactionRecord")
public class TransactionRecord {
    @Id
    @Size(max = 5)
    private String TransactionId;
    @Column(columnDefinition = "date")
    private String TransactionDate;
    @Column
    private String FlightId;
    @ManyToOne
    @JoinColumn(name="UserId")
    private User UserId;
    @Column
    private Integer Ammount;

    public TransactionRecord(String transactionId, String transactionDate, String flightId, User userId, Integer ammount) {
        TransactionId = transactionId;
        TransactionDate = transactionDate;
        FlightId = flightId;
        UserId = userId;
        Ammount = ammount;
    }

    public User getUserId() {
        return UserId;
    }

    public void setUserId(User userId) {
        UserId = userId;
    }

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        TransactionDate = transactionDate;
    }

    public String getFlightId() {
        return FlightId;
    }

    public void setFlightId(String flightId) {
        FlightId = flightId;
    }

    public Integer getAmmount() {
        return Ammount;
    }

    public void setAmmount(Integer ammount) {
        Ammount = ammount;
    }
}
