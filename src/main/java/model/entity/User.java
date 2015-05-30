package model.entity;

import javassist.bytecode.ByteArray;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author asmolik
 * Klasa reprezentuj¹ca encje User. Ma ona przechowywaæ dane
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
     * chas³o u¿ytkownika
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User object = (User) o;

        return !(email != null ? !email.equals(object.email) : object.email != null);
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
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
