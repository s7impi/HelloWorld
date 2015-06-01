package model.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

/**
 * Klasa odpowiedzialna za implementacje oraz skonfigurowanie
 * EntityManagera, oraz przygotowanie do jego dzialania.
 * Created by Marz on 2015-05-29.
 */
public abstract class EntityManagerComposer {


    protected EntityManager entityManager;
    protected UserTransaction userTransaction;

    public EntityManagerComposer()
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

    public EntityManagerComposer(EntityManager em, UserTransaction ut) {
        entityManager = em;
        userTransaction = ut;
    }
}

