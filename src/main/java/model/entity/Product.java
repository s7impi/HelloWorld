package model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author asmolik
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    int price;
    String info;
    String category;
    double rating;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    List<Opinion> opinions;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
