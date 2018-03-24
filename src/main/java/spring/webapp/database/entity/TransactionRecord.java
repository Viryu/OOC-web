package spring.webapp.database.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="TransactionRecord")
public class TransactionRecord {
    @Id
    private String TransactionId;
    @Column(columnDefinition = "date")
    private String TransactionDate;
    @Column
    private Integer UserId;
    @Column
    private String FlightId;
    @Column
    private Integer NoPassenger;
    @Column
    private String BookingStatus;

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

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getFlightId() {
        return FlightId;
    }

    public void setFlightId(String flightId) {
        FlightId = flightId;
    }

    public Integer getNoPassenger() {
        return NoPassenger;
    }

    public void setNoPassenger(Integer noPassenger) {
        NoPassenger = noPassenger;
    }

    public String getBookingStatus() {
        return BookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        BookingStatus = bookingStatus;
    }
}
