package spring.webapp.database.entity;

import javax.persistence.*;

@Entity
@Table(name="TransactionRecord")
public class TransactionRecord {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer TransactionId;
    @Column(columnDefinition = "date")
    private String transactiondate;
    @Column
    private Integer userid;
    @Column
    private String flightno;
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

    public String getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(String transactiondate) {
        this.transactiondate = transactiondate;
    }

    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFlightno() {
        return flightno;
    }

    public void setFlightid(String flightno) {
        this.flightno = flightno;
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

    public TransactionRecord(String transactiondate, Integer userid, String flightno, String namePrefix, String passengername, String bookingcode, String idnumber, String idtype, float pricetopay) {
        this.transactiondate = transactiondate;
        this.userid = userid;
        this.flightno = flightno;
        this.namePrefix = namePrefix;
        this.passengername = passengername;
        this.bookingcode = bookingcode;
        this.idnumber = idnumber;
        this.idtype = idtype;
        this.pricetopay = pricetopay;
    }
}
