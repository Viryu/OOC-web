package spring.webapp.database.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="FlightDetail")
public class FlightDetail {
    @NotNull
    @Id
    @Size(max = 5)
    private String FlightID;
    @Column(nullable=false)
    private String destination;
    @Column(nullable=false)
    private String startdestination;
    @Column(columnDefinition = "date" , nullable=false)
    private String dod;
    @Column
    private Integer seatleft;

    protected FlightDetail(){

    }
    public FlightDetail(String flightID, String destination, String startdestination, String dod, Integer seatleft) {
        FlightID = flightID;
        this.destination = destination;
        this.startdestination = startdestination;
        this.dod = dod;
        this.seatleft = seatleft;
    }

    public String getFlightID() {
        return FlightID;
    }

    public void setFlightID(String flightID) {
        FlightID = flightID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartdestination() {
        return startdestination;
    }

    public void setStartdestination(String startdestination) {
        this.startdestination = startdestination;
    }

    public String getDod() {
        return dod;
    }

    public void setDod(String dod) {
        this.dod = dod;
    }

    public Integer getSeatleft() {
        return seatleft;
    }

    public void setSeatleft(Integer seatleft) {
        this.seatleft = seatleft;
    }
}
