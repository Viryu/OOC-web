package spring.webapp.database.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class FlightDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Integer flightid;
    @Column(nullable=false)
    private String startdestination;
    @Column(nullable=false)
    private String enddestination;
    @Column
    private String arrivaldate;
    @Column(length=10)
    private String arrivaltime;
    @Column
    private String departuredate;
    @Column(length=10)
    private String departuretime;
    @Column(length=5)
    private Integer seatleft;
    @Column(length=5)
    private Integer seatmax;
    @Column(length=20)
    private String airline;
    @Column(length=8)
    private String flightno;
    @Column
    private float price; // in bahts

    public Integer getFlightid() {
        return flightid;
    }

    public void setFlightid(Integer flightid) {
        this.flightid = flightid;
    }

    public String getStartdestination() {
        return startdestination;
    }

    public void setStartdestination(String startdestination) {
        this.startdestination = startdestination;
    }

    public String getEnddestination() {
        return enddestination;
    }

    public void setEnddestination(String enddestination) {
        this.enddestination = enddestination;
    }

    public String getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(String arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(String departuredate) {
        this.departuredate = departuredate;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public Integer getSeatleft() {
        return seatleft;
    }

    public void setSeatleft(Integer seatleft) {
        this.seatleft = seatleft;
    }

    public Integer getSeatmax() {
        return seatmax;
    }

    public void setSeatmax(Integer seatmax) {
        this.seatmax = seatmax;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightno() {
        return flightno;
    }

    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
