package spring.webapp.database.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
    @Id
    private Integer id;

    @Column(length=30, nullable=false)
    private String firstName;

    @Column(length=30, nullable=false)
    private String lastName;

    @Column(columnDefinition="date", nullable=false)
    private String dob;

    @Column(columnDefinition="int(20)", nullable=false)
    private Integer phoneNumber;

    protected UserInfo() {}

    public UserInfo(Integer id, String firstName, String lastName, String dob, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phoneNumber = Integer.parseInt(phoneNumber);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
