package model.entity;

import javax.persistence.*;

/**
 * Created by Marz on 2015-05-31.
 */
@Entity
@Table(name = "carts_has_games", schema = "", catalog = "pikdb")
@IdClass(CartsHasGamesPK.class)
public class CartsHasGames {
    private int gamesIdgames;
    private String cartsUsersEmail;
    private int quantity;
    private Carts cartsByCartsUsersEmail;
    private Games gamesByGamesIdgames;

    @Id
    @Column(name = "games_idgames", nullable = false, insertable = true, updatable = true)
    public int getGamesIdgames() {
        return gamesIdgames;
    }

    public void setGamesIdgames(int gamesIdgames) {
        this.gamesIdgames = gamesIdgames;
    }

    @Id
    @Column(name = "carts_users_email", nullable = false, insertable = true, updatable = true, length = 45)
    public String getCartsUsersEmail() {
        return cartsUsersEmail;
    }

    public void setCartsUsersEmail(String cartsUsersEmail) {
        this.cartsUsersEmail = cartsUsersEmail;
    }

    @Basic
    @Column(name = "quantity", nullable = false, insertable = true, updatable = true)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartsHasGames that = (CartsHasGames) o;

        return gamesIdgames == that.gamesIdgames && quantity == that.quantity && !(cartsUsersEmail != null ? !cartsUsersEmail.equals(that.cartsUsersEmail) : that.cartsUsersEmail != null);

    }

    @Override
    public int hashCode() {
        int result = gamesIdgames;
        result = 31 * result + (cartsUsersEmail != null ? cartsUsersEmail.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "carts_users_email", referencedColumnName = "users_email", nullable = false, updatable = false, insertable = false)
    public Carts getCartsByCartsUsersEmail() {
        return cartsByCartsUsersEmail;
    }

    public void setCartsByCartsUsersEmail(Carts cartsByCartsUsersEmail) {
        this.cartsByCartsUsersEmail = cartsByCartsUsersEmail;
    }

    @ManyToOne
    @JoinColumn(name = "games_idgames", referencedColumnName = "idgames", nullable = false, updatable = false, insertable = false)
    public Games getGamesByGamesIdgames() {
        return gamesByGamesIdgames;
    }

    public void setGamesByGamesIdgames(Games gamesByGamesIdgames) {
        this.gamesByGamesIdgames = gamesByGamesIdgames;
    }
}
