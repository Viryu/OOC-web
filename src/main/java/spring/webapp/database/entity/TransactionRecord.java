package spring.webapp.database.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="TransactionRecord")
public class TransactionRecord {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer TransactionId;
    @Column(columnDefinition = "date")
    private String TransactionDate;
    @Column
    private Integer userid;
    @Column
    private String flightid;
    @Column
    private String namePrefix;
    @Column
    private String passengername;
    @Column
    private String passengeridentification;
    @Column
    private String BookingStatus;

    public Integer getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(Integer transactionId) {
        TransactionId = transactionId;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        TransactionDate = transactionDate;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFlightid() {
        return flightid;
    }

    public void setFlightid(String flightid) {
        this.flightid = flightid;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getPassengername() {
        return passengername;
    }

    public void setPassengername(String passengername) {
        this.passengername = passengername;
    }

    public String getPassengeridentification() {
        return passengeridentification;
    }

    public void setPassengeridentification(String passengeridentification) {
        this.passengeridentification = passengeridentification;
    }

    public String getBookingStatus() {
        return BookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        BookingStatus = bookingStatus;
    }
    protected TransactionRecord(){}
    public TransactionRecord(String transactionDate, String namePrefix, String passengername, String passengeridentification, String bookingStatus) {
        TransactionDate = transactionDate;
        this.namePrefix = namePrefix;
        this.passengername = passengername;
        this.passengeridentification = passengeridentification;
        BookingStatus = bookingStatus;
    }
}
