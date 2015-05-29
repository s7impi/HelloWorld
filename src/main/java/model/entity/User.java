package model.entity;

import javassist.bytecode.ByteArray;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author asmolik
 * Klasa reprezentująca encje User. Ma ona przechowywać dane
 * o koncie uzytkownika.
 */
@Entity(name = "users")
@XmlRootElement
public class User implements Serializable{

    /**
     * email uzytkownika. Musi zostac podany
     */
    @Id
    @NotNull
    @Column(name = "email")
    private String email;

    /**
     * chasło użytkownika
     */
    @Column(name = "password")
    private String password;
//    Cart cart;
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "")
//    List<Order> orders;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
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
