package model.dao;

/**
 * Created by Marz on 2015-05-02.
 */
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="USERS")
public class UserDB implements Serializable {

    @Column(name="id", unique=true)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="password",nullable = false)
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
