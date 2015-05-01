package model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * @author asmolik
 */
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    Date dateCreated;
    String status;
//    @OneToMany
//    List<Item> items;
    int total;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;

    public Order(int total) {
        this.total = total;
        status = "start";
    }
}
