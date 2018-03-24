package spring.webapp.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminInfo {
    @Id
    private Integer adminID;
    @Column
    private String airline;

    protected AdminInfo() {}

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public AdminInfo(Integer adminID, String airline) {
        this.adminID = adminID;
        this.airline = airline;
    }


}
