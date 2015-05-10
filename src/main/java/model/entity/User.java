package model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author asmolik
 */
@Entity(name = "users")
@XmlRootElement
public class User {
    @Id
    @NotNull
    @Column(name = "user_name")
    String email;
    @Column(name = "user_password")
    String password;
//    Cart cart;
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "")
//    List<Order> orders;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public void createOrder() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
