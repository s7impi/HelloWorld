package model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author asmolik
 */
@Entity(name = "users")
public class User {
    @Id
    @NotNull
    @Column(name = "user_name")
    String username;
    @Column(name = "user_password")
    String password;
//    Cart cart;
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "")
//    List<Order> orders;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public void createOrder() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
