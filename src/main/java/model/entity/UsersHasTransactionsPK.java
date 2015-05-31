package model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Marz on 2015-05-31.
 */
public class UsersHasTransactionsPK implements Serializable {
    private String usersEmail;
    private int transactionsIdtransactions;

    @Column(name = "users_email", nullable = false, insertable = true, updatable = true, length = 45)
    @Id
    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    @Column(name = "transactions_idtransactions", nullable = false, insertable = true, updatable = true)
    @Id
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

        UsersHasTransactionsPK that = (UsersHasTransactionsPK) o;

        return transactionsIdtransactions == that.transactionsIdtransactions && !(usersEmail != null ? !usersEmail.equals(that.usersEmail) : that.usersEmail != null);

    }

    @Override
    public int hashCode() {
        int result = usersEmail != null ? usersEmail.hashCode() : 0;
        result = 31 * result + transactionsIdtransactions;
        return result;
    }
}
