package model.entity;

import javax.persistence.*;

/**
 * Created by Marz on 2015-05-31.
 */
@Entity
@Table(name = "transactions_has_games", schema = "", catalog = "pikdb")
@IdClass(TransactionsHasGamesPK.class)
public class TransactionsHasGames {
    private int transactionsIdtransactions;
    private int gamesIdgames;
    private int quantity;
    private Games gamesByGamesIdgames;
    private Transactions transactionsByTransactionsIdtransactions;

    @Id
    @Column(name = "transactions_idtransactions", nullable = false, insertable = true, updatable = true)
    public int getTransactionsIdtransactions() {
        return transactionsIdtransactions;
    }

    public void setTransactionsIdtransactions(int transactionsIdtransactions) {
        this.transactionsIdtransactions = transactionsIdtransactions;
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

        TransactionsHasGames that = (TransactionsHasGames) o;

        return transactionsIdtransactions == that.transactionsIdtransactions && gamesIdgames == that.gamesIdgames && quantity == that.quantity;

    }

    @Override
    public int hashCode() {
        int result = transactionsIdtransactions;
        result = 31 * result + gamesIdgames;
        result = 31 * result + quantity;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "games_idgames", referencedColumnName = "idgames", nullable = false, updatable = false, insertable = false)
    public Games getGamesByGamesIdgames() {
        return gamesByGamesIdgames;
    }

    public void setGamesByGamesIdgames(Games gamesByGamesIdgames) {
        this.gamesByGamesIdgames = gamesByGamesIdgames;
    }

    @ManyToOne
    @JoinColumn(name = "transactions_idtransactions", referencedColumnName = "idtransactions", nullable = false, updatable = false, insertable = false)
    public Transactions getTransactionsByTransactionsIdtransactions() {
        return transactionsByTransactionsIdtransactions;
    }

    public void setTransactionsByTransactionsIdtransactions(Transactions transactionsByTransactionsIdtransactions) {
        this.transactionsByTransactionsIdtransactions = transactionsByTransactionsIdtransactions;
    }
}
