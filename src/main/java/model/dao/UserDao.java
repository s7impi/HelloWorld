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
 * Klasa pozwalajaca na dostep do Tabeli users
 * @author marzuz
 */
@Stateless
public class UserDao extends EntityManagerComposer{


    /**
     * Pozwala znalesc uzytkownika po jego emailu/nazwie
     * @param name -email/nazwa
     * @return obiekt klasy User o podanym nicku
     */
    public User findUser(String name) {
        return entityManager.find(User.class, name);
    }


    /**
     * Pozwala zapisac nowego uzytkownika do bazy danych
     * @param user -obiekt kalsy User do zapisania
     * @throws SystemException
     * @throws NotSupportedException
     * @throws HeuristicRollbackException
     * @throws HeuristicMixedException
     * @throws RollbackException
     */
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
