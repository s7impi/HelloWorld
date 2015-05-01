package model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author asmolik
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    Cart cart;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "")
    List<Order> orders;

    public User(String name) {
        this.name = name;
    }

    public void createOrder() {

    }

    public Cart getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }
}
