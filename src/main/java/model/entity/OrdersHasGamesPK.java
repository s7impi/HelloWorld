package model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Marz on 2015-05-31.
 */
public class OrdersHasGamesPK implements Serializable {
    private int ordersIdorders;
    private int gamesIdgames;

    @Column(name = "orders_idorders", nullable = false, insertable = true, updatable = true)
    @Id
    public int getOrdersIdorders() {
        return ordersIdorders;
    }

    public void setOrdersIdorders(int ordersIdorders) {
        this.ordersIdorders = ordersIdorders;
    }

    @Column(name = "games_idgames", nullable = false, insertable = true, updatable = true)
    @Id
    public int getGamesIdgames() {
        return gamesIdgames;
    }

    public void setGamesIdgames(int gamesIdgames) {
        this.gamesIdgames = gamesIdgames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersHasGamesPK that = (OrdersHasGamesPK) o;

        if (ordersIdorders != that.ordersIdorders) return false;
        if (gamesIdgames != that.gamesIdgames) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ordersIdorders;
        result = 31 * result + gamesIdgames;
        return result;
    }
}
