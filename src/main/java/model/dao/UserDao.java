package model.dao;

import model.entity.Users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
    public Users findUser(String name) {
        return entityManager.find(Users.class, name);
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
    public void save(Users user) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException, TransactionNotOpenException {
        userTransaction.begin();
        if(entityManager.isOpen()){
            entityManager.joinTransaction();
            entityManager.persist(user);
            entityManager.flush();
            userTransaction.commit();
        } else
            throw new TransactionNotOpenException();
    }

    public UserDao(EntityManager em, UserTransaction ut) {
        super(em, ut);
        entityManager = em;
    }

}
