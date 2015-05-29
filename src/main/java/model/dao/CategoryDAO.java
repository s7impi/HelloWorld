package model.dao;

import model.entity.Category;

import javax.ejb.Stateless;
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
    public Category getCategory(String categoryName){
        return entityManager.find(Category.class, categoryName);
    }


    /**
     * funkcja zwracajaca wszystkie encje Categories z bazy
     * @return lista encji Categories
     */
    public List<Category> getAllCategories(){
        return entityManager.createQuery("SELECT e from categories e").getResultList();
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
    public void insertNewCategory(Category newCategory) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException, TransactionNotOpenException {
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
}
