package model.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Marz on 2015-05-31.
 */
@Entity
public class Transactions {
    private int idtransactions;
    private String status;
    private BigInteger price;
    private Date date;
    private Collection<TransactionsHasGames> transactionsHasGamesByIdtransactions;
    private Collection<UsersHasTransactions> usersHasTransactionsesByIdtransactions;

    @Id
    @Column(name = "idtransactions", nullable = false, insertable = true, updatable = true)
    public int getIdtransactions() {
        return idtransactions;
    }

    public void setIdtransactions(int idtransactions) {
        this.idtransactions = idtransactions;
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
    @Column(name = "price", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @Basic
    @Column(name = "date", nullable = false, insertable = true, updatable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transactions that = (Transactions) o;

        return idtransactions == that.idtransactions && !(status != null ? !status.equals(that.status) : that.status != null) && !(price != null ? !price.equals(that.price) : that.price != null) && !(date != null ? !date.equals(that.date) : that.date != null);

    }

    @Override
    public int hashCode() {
        int result = idtransactions;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "transactionsByTransactionsIdtransactions")
    public Collection<TransactionsHasGames> getTransactionsHasGamesByIdtransactions() {
        return transactionsHasGamesByIdtransactions;
    }

    public void setTransactionsHasGamesByIdtransactions(Collection<TransactionsHasGames> transactionsHasGamesByIdtransactions) {
        this.transactionsHasGamesByIdtransactions = transactionsHasGamesByIdtransactions;
    }

    @OneToMany(mappedBy = "transactionsByTransactionsIdtransactions")
    public Collection<UsersHasTransactions> getUsersHasTransactionsesByIdtransactions() {
        return usersHasTransactionsesByIdtransactions;
    }

    public void setUsersHasTransactionsesByIdtransactions(Collection<UsersHasTransactions> usersHasTransactionsesByIdtransactions) {
        this.usersHasTransactionsesByIdtransactions = usersHasTransactionsesByIdtransactions;
    }
}
