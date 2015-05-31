package model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Marz on 2015-05-31.
 */
public class CartsHasGamesPK implements Serializable {
    private int gamesIdgames;
    private String cartsUsersEmail;

    @Column(name = "games_idgames", nullable = false, insertable = true, updatable = true)
    @Id
    public int getGamesIdgames() {
        return gamesIdgames;
    }

    public void setGamesIdgames(int gamesIdgames) {
        this.gamesIdgames = gamesIdgames;
    }

    @Column(name = "carts_users_email", nullable = false, insertable = true, updatable = true, length = 45)
    @Id
    public String getCartsUsersEmail() {
        return cartsUsersEmail;
    }

    public void setCartsUsersEmail(String cartsUsersEmail) {
        this.cartsUsersEmail = cartsUsersEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartsHasGamesPK that = (CartsHasGamesPK) o;

        return gamesIdgames == that.gamesIdgames && !(cartsUsersEmail != null ? !cartsUsersEmail.equals(that.cartsUsersEmail) : that.cartsUsersEmail != null);

    }

    @Override
    public int hashCode() {
        int result = gamesIdgames;
        result = 31 * result + (cartsUsersEmail != null ? cartsUsersEmail.hashCode() : 0);
        return result;
    }
}
