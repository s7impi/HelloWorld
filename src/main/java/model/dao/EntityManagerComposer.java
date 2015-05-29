package model.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

/**
 * Created by Marz on 2015-05-29.
 */
public abstract class EntityManagerComposer {

    public EntityManager entityManager;
    public UserTransaction userTransaction;

    {
        InitialContext ctx;
        try {
            ctx = new InitialContext();
            userTransaction = (UserTransaction)ctx.lookup("java:comp/UserTransaction");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        entityManager = emf.createEntityManager();
    }
}

class TransactionNotOpenException extends Exception{}