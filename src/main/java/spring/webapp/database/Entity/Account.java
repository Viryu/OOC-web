package spring.webapp.database.Entity;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(length=60, unique=true, nullable=false)
    private String email;

    @Column(length=20, nullable=false)
    private String password;

    @Column(columnDefinition="char(10)", nullable=false)
    private String role;

    protected Account() {}

    public Account(String email, String password, String role)  {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}