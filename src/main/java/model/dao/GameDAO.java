package model.dao;

import model.entity.Games;

import javax.transaction.*;
import java.util.List;

/**
 * klasa odpowiedzialna za dostep do encji games
 * Created by Marz on 2015-05-29.
 */
public class GameDAO extends EntityManagerComposer {


    /**
     * funkcja szukaj¹ca gry po jej nazwie, ktora jest kluczem glownym
     * @param id - nazwa gry
     * @return klasa Game
     */
    public Games findGame(Integer id) {
        return entityManager.find(Games.class, id);
    }


    public List<Games> findGameByName(String name) {
        return entityManager.createQuery("SELECT e from Games e where e.name = :searching_name", Games.class).setParameter("searching_name", name).getResultList();
    }
    /**
     * znajduje wszystkie wiersze encji games
     * @return lista encji games
     */
    public List<Games> findAllGames() {
        return entityManager.createQuery("SELECT e from Games e", Games.class).getResultList();
    }


    /**
     * pozwala wstawic wiersz do encji games
     * @param game -- obiekt klasy Game reprezentujacy wiersz encji games
     * @throws SystemException
     * @throws NotSupportedException
     * @throws HeuristicRollbackException
     * @throws HeuristicMixedException
     * @throws RollbackException
     * @throws TransactionNotOpenException
     */
    public void insertGame(Games game) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException, TransactionNotOpenException {
        userTransaction.begin();
        if(entityManager.isOpen()){
            entityManager.joinTransaction();
            entityManager.persist(game);
            entityManager.flush();
            userTransaction.commit();
        }
        else
            throw new TransactionNotOpenException();
    }

    /**
     * pozwala odswiezyc dane gdyz nie zawsze moga byc aktualne w programie.
     * @param game gra ktorej dane chcemy odswiezyc
     * @throws SystemException
     * @throws NotSupportedException
     * @throws HeuristicRollbackException
     * @throws HeuristicMixedException
     * @throws RollbackException
     * @throws TransactionNotOpenException
     */
    public void refreshGame(Games game) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException, TransactionNotOpenException {
        userTransaction.begin();
        if(entityManager.isOpen()){
            entityManager.joinTransaction();
            entityManager.refresh(game);
            entityManager.flush();
            userTransaction.commit();
        }
        else
            throw new TransactionNotOpenException();
    }
}
