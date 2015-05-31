package model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Marz on 2015-05-31.
 */
@Entity
public class Carts {
    private String usersEmail;
    private Users usersByUsersEmail;
    private Collection<CartsHasGames> cartsHasGamesByUsersEmail;

    @Id
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

        Carts carts = (Carts) o;

        return !(usersEmail != null ? !usersEmail.equals(carts.usersEmail) : carts.usersEmail != null);

    }

    @Override
    public int hashCode() {
        return usersEmail != null ? usersEmail.hashCode() : 0;
    }

    @OneToOne
    @JoinColumn(name = "users_email", referencedColumnName = "email", nullable = false)
    public Users getUsersByUsersEmail() {
        return usersByUsersEmail;
    }

    public void setUsersByUsersEmail(Users usersByUsersEmail) {
        this.usersByUsersEmail = usersByUsersEmail;
    }

    @OneToMany(mappedBy = "cartsByCartsUsersEmail")
    public Collection<CartsHasGames> getCartsHasGamesByUsersEmail() {
        return cartsHasGamesByUsersEmail;
    }

    public void setCartsHasGamesByUsersEmail(Collection<CartsHasGames> cartsHasGamesByUsersEmail) {
        this.cartsHasGamesByUsersEmail = cartsHasGamesByUsersEmail;
    }
}
