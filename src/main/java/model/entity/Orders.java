package model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Marz on 2015-05-31.
 */
@Entity
public class Orders {
    private int idorders;
    private Date date;
    private float price;
    private String status;
    private String usersEmail;
    private Users usersByUsersEmail;
    private Collection<OrdersHasGames> ordersHasGamesByIdorders;

    @Id
    @Column(name = "idorders", nullable = false, insertable = true, updatable = true)
    public int getIdorders() {
        return idorders;
    }

    public void setIdorders(int idorders) {
        this.idorders = idorders;
    }

    @Basic
    @Column(name = "date", nullable = false, insertable = true, updatable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "status", nullable = false, insertable = true, updatable = true, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "users_email", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (idorders != orders.idorders) return false;
        if (Float.compare(orders.price, price) != 0) return false;
        if (date != null ? !date.equals(orders.date) : orders.date != null) return false;
        if (status != null ? !status.equals(orders.status) : orders.status != null) return false;
        if (usersEmail != null ? !usersEmail.equals(orders.usersEmail) : orders.usersEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idorders;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (usersEmail != null ? usersEmail.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "users_email", referencedColumnName = "email", nullable = false, updatable = false, insertable = false)
    public Users getUsersByUsersEmail() {
        return usersByUsersEmail;
    }

    public void setUsersByUsersEmail(Users usersByUsersEmail) {
        this.usersByUsersEmail = usersByUsersEmail;
    }

    @OneToMany(mappedBy = "ordersByOrdersIdorders")
    public Collection<OrdersHasGames> getOrdersHasGamesByIdorders() {
        return ordersHasGamesByIdorders;
    }

    public void setOrdersHasGamesByIdorders(Collection<OrdersHasGames> ordersHasGamesByIdorders) {
        this.ordersHasGamesByIdorders = ordersHasGamesByIdorders;
    }
}
