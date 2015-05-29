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
public class UserDao extends EntityManagerComposer{


    public User find(String name) {
        return entityManager.find(User.class, name);
    }

    public void save(User user) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        userTransaction.begin();
        if(entityManager.isOpen()){
            entityManager.joinTransaction();
            entityManager.persist(user);
            entityManager.flush();
            userTransaction.commit();
        }
    }


}
