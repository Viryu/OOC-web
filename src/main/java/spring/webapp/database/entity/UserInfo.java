package spring.webapp.database.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
    @Id
    private Integer userid;

    @Column(length=30, nullable=false)
    private String firstName;

    @Column(length=30, nullable=false)
    private String lastName;

    @Column(columnDefinition="date", nullable=false)
    private String dob;

    @Column(columnDefinition="varchar(20)", nullable=false)
    private String phoneNumber;

    protected UserInfo() {}

    public UserInfo(Integer id, String firstName, String lastName, String dob, String phoneNumber) {
        this.userid = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return userid;
    }

    public void setId(Integer id) {
        this.userid = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
