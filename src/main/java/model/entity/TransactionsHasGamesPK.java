package model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Marz on 2015-05-31.
 */
public class TransactionsHasGamesPK implements Serializable {
    private int transactionsIdtransactions;
    private int gamesIdgames;

    @Column(name = "transactions_idtransactions", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTransactionsIdtransactions() {
        return transactionsIdtransactions;
    }

    public void setTransactionsIdtransactions(int transactionsIdtransactions) {
        this.transactionsIdtransactions = transactionsIdtransactions;
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

        TransactionsHasGamesPK that = (TransactionsHasGamesPK) o;

        if (transactionsIdtransactions != that.transactionsIdtransactions) return false;
        if (gamesIdgames != that.gamesIdgames) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionsIdtransactions;
        result = 31 * result + gamesIdgames;
        return result;
    }
}
