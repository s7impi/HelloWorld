package model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Marz on 2015-05-31.
 */
@Entity
public class Users {
    private String email;
    private String password;
    private Carts cartsByEmail;
    private Collection<Orders> ordersesByEmail;
    private Collection<Reviews> reviewsesByEmail;
    private Collection<UsersHasTransactions> usersHasTransactionsesByEmail;

    @Id
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "usersByUsersEmail")
    public Carts getCartsByEmail() {
        return cartsByEmail;
    }

    public void setCartsByEmail(Carts cartsByEmail) {
        this.cartsByEmail = cartsByEmail;
    }

    @OneToMany(mappedBy = "usersByUsersEmail")
    public Collection<Orders> getOrdersesByEmail() {
        return ordersesByEmail;
    }

    public void setOrdersesByEmail(Collection<Orders> ordersesByEmail) {
        this.ordersesByEmail = ordersesByEmail;
    }

    @OneToMany(mappedBy = "usersByUsersEmail")
    public Collection<Reviews> getReviewsesByEmail() {
        return reviewsesByEmail;
    }

    public void setReviewsesByEmail(Collection<Reviews> reviewsesByEmail) {
        this.reviewsesByEmail = reviewsesByEmail;
    }

    @OneToMany(mappedBy = "usersByUsersEmail")
    public Collection<UsersHasTransactions> getUsersHasTransactionsesByEmail() {
        return usersHasTransactionsesByEmail;
    }

    public void setUsersHasTransactionsesByEmail(Collection<UsersHasTransactions> usersHasTransactionsesByEmail) {
        this.usersHasTransactionsesByEmail = usersHasTransactionsesByEmail;
    }
}
