package model.dao;

import model.entity.User;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;


/**
 * @author marzuz
 */
@Stateless
public class UserDao {

    private EntityManager entityManager;
    private UserTransaction userTransaction;

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

    public User find(String name) {
        return entityManager.find(User.class, name);
    }

    public void save(User user) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        userTransaction.begin();
        if(entityManager.isOpen())
        {
            entityManager.joinTransaction();
            entityManager.persist(user);
            entityManager.flush();
            userTransaction.commit();
        }
    }


}
