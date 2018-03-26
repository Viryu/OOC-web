package spring.webapp.database.entity;

import javax.persistence.*;

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
    private String bookingcode;
    @Column
    private String idnumber;
    @Column
    private String idtype;
    @Column
    private float pricetopay;
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

    public String getBookingcode() {
        return bookingcode;
    }

    public void setBookingcode(String bookingcode) {
        this.bookingcode = bookingcode;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    protected TransactionRecord(){}

    public float getPricetopay() {
        return pricetopay;
    }

    public void setPricetopay(float pricetopay) {
        this.pricetopay = pricetopay;
    }

    public TransactionRecord(String transactionDate, Integer userid, String flightid, String namePrefix, String passengername, String bookingcode, String idnumber, String idtype, float pricetopay) {
        TransactionDate = transactionDate;
        this.userid = userid;
        this.flightid = flightid;
        this.namePrefix = namePrefix;
        this.passengername = passengername;
        this.bookingcode = bookingcode;
        this.idnumber = idnumber;
        this.idtype = idtype;
        this.pricetopay = pricetopay;
    }
}
