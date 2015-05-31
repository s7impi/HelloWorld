package model.entity;

import javax.persistence.*;

/**
 * Created by Marz on 2015-05-31.
 */
@Entity
@Table(name = "orders_has_games", schema = "", catalog = "pikdb")
@IdClass(OrdersHasGamesPK.class)
public class OrdersHasGames {
    private int ordersIdorders;
    private int gamesIdgames;
    private Integer quantity;
    private Games gamesByGamesIdgames;
    private Orders ordersByOrdersIdorders;

    @Id
    @Column(name = "orders_idorders", nullable = false, insertable = true, updatable = true)
    public int getOrdersIdorders() {
        return ordersIdorders;
    }

    public void setOrdersIdorders(int ordersIdorders) {
        this.ordersIdorders = ordersIdorders;
    }

    @Id
    @Column(name = "games_idgames", nullable = false, insertable = true, updatable = true)
    public int getGamesIdgames() {
        return gamesIdgames;
    }

    public void setGamesIdgames(int gamesIdgames) {
        this.gamesIdgames = gamesIdgames;
    }

    @Basic
    @Column(name = "quantity", nullable = true, insertable = true, updatable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersHasGames that = (OrdersHasGames) o;

        return ordersIdorders == that.ordersIdorders && gamesIdgames == that.gamesIdgames && !(quantity != null ? !quantity.equals(that.quantity) : that.quantity != null);

    }

    @Override
    public int hashCode() {
        int result = ordersIdorders;
        result = 31 * result + gamesIdgames;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "games_idgames", referencedColumnName = "idgames", nullable = false, insertable = false, updatable = false)
    public Games getGamesByGamesIdgames() {
        return gamesByGamesIdgames;
    }

    public void setGamesByGamesIdgames(Games gamesByGamesIdgames) {
        this.gamesByGamesIdgames = gamesByGamesIdgames;
    }

    @ManyToOne
    @JoinColumn(name = "orders_idorders", referencedColumnName = "idorders", nullable = false, insertable = false, updatable = false)
    public Orders getOrdersByOrdersIdorders() {
        return ordersByOrdersIdorders;
    }

    public void setOrdersByOrdersIdorders(Orders ordersByOrdersIdorders) {
        this.ordersByOrdersIdorders = ordersByOrdersIdorders;
    }
}
