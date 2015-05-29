package model.dao;

import model.entity.Game;

import javax.transaction.*;

/**
 * klasa odpowiedzialna za dostep do encji games
 * Created by Marz on 2015-05-29.
 */
public class GameDAO extends EntityManagerComposer {


    /**
     * funkcja szukaj¹ca gry po jej nazwie, ktora jest kluczem glownym
     * @param name - nazwa gry
     * @return klasa Game
     */
    public Game findGame(String name){
        return entityManager.find(Game.class, name);
    }

    public void insertGame(Game game) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException, TransactionNotOpenException {
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
}
