package model.entity;

import javax.persistence.*;

/**
 * Created by Marz on 2015-05-31.
 */
@Entity
@Table(name = "users_has_transactions", schema = "", catalog = "pikdb")
@IdClass(UsersHasTransactionsPK.class)
public class UsersHasTransactions {
    private String usersEmail;
    private int transactionsIdtransactions;
    private Transactions transactionsByTransactionsIdtransactions;
    private Users usersByUsersEmail;

    @Id
    @Column(name = "users_email", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    @Id
    @Column(name = "transactions_idtransactions", nullable = false, insertable = true, updatable = true)
    public int getTransactionsIdtransactions() {
        return transactionsIdtransactions;
    }

    public void setTransactionsIdtransactions(int transactionsIdtransactions) {
        this.transactionsIdtransactions = transactionsIdtransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersHasTransactions that = (UsersHasTransactions) o;

        return transactionsIdtransactions == that.transactionsIdtransactions && !(usersEmail != null ? !usersEmail.equals(that.usersEmail) : that.usersEmail != null);

    }

    @Override
    public int hashCode() {
        int result = usersEmail != null ? usersEmail.hashCode() : 0;
        result = 31 * result + transactionsIdtransactions;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "transactions_idtransactions", referencedColumnName = "idtransactions", nullable = false, updatable = false, insertable = false)
    public Transactions getTransactionsByTransactionsIdtransactions() {
        return transactionsByTransactionsIdtransactions;
    }

    public void setTransactionsByTransactionsIdtransactions(Transactions transactionsByTransactionsIdtransactions) {
        this.transactionsByTransactionsIdtransactions = transactionsByTransactionsIdtransactions;
    }

    @ManyToOne
    @JoinColumn(name = "users_email", referencedColumnName = "email", nullable = false, updatable = false, insertable = false)
    public Users getUsersByUsersEmail() {
        return usersByUsersEmail;
    }

    public void setUsersByUsersEmail(Users usersByUsersEmail) {
        this.usersByUsersEmail = usersByUsersEmail;
    }
}
