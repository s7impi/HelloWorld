package model.dao;

import model.entity.Categories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.transaction.*;
import java.util.List;

/**
 * Created by Marz on 2015-05-29.
 * CategoryDAO - klasa odpowiedzialna za dostêp do encji Category
 */
@Stateless
public class CategoryDAO extends EntityManagerComposer{



    /**
     * funkcja zwraca encje o podanym identyfikatorze: name
     * @param categoryName - nazwa identyfikatora
     * @return encja o podanym identyfikatorze
     */
    public Categories getCategory(String categoryName) {
        return entityManager.find(Categories.class, categoryName);
    }


    /**
     * funkcja zwracajaca wszystkie encje Categories z bazy
     * @return lista encji Categories
     */
    public List<Categories> getAllCategories() {
        return entityManager.createQuery("SELECT e from Categories e", Categories.class).getResultList();
    }


    /**
     * funkcja pozwalajaca dodac nowy wiersz do encji Category
     * @param newCategory klasa reprezentuj¹ca wiersz encji Category
     * @throws SystemException
     * @throws NotSupportedException
     * @throws HeuristicRollbackException
     * @throws HeuristicMixedException
     * @throws RollbackException
     * @throws TransactionNotOpenException
     */
    public void insertNewCategory(Categories newCategory) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException, TransactionNotOpenException {
        userTransaction.begin();
        if(entityManager.isOpen()){
            entityManager.joinTransaction();
            entityManager.persist(newCategory);
            entityManager.flush();
            userTransaction.commit();
        }
        else
            throw new TransactionNotOpenException();
    }

    public CategoryDAO(EntityManager em, UserTransaction ut) {
        super(em, ut);
    }

    public CategoryDAO() {
        super();
    }
}
