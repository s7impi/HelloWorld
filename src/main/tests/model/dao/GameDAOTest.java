package model.dao;

import model.entity.Games;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import java.util.LinkedList;
import java.util.List;

/**
 * Testy dla klasy GamesDAO
 * Created by Marz on 2015-06-01.
 */
public class GameDAOTest {

    GameDAO dao;
    EntityManager em;
    UserTransaction ut;


    @Before
    public void setUp() throws Exception {
        em = Mockito.mock(EntityManager.class);
        ut = Mockito.mock(UserTransaction.class);
        dao = new GameDAO(em, ut);

    }

    @Test
    public void testFindGameByNameWhenGoodParam() throws Exception {
        List<Games> list = new LinkedList<>();
        Mockito.when(em.createQuery("SELECT e from Games e where e.name = :searching_name", Games.class).setParameter("searching_name", "Talizman").getResultList()).thenReturn(list);
        Assert.assertSame(list, dao.findGameByName("Talizman"));
    }

    @Test
    public void testFindAllGamesWhenGoodParam() throws Exception {
        List<Games> list = new LinkedList<>();
        Mockito.when(em.createQuery("SELECT e from Games e", Games.class).getResultList()).thenReturn(list);
        Assert.assertSame(list, dao.findAllGames());
    }

    @Test
    public void testFindGameByNameWhenBadParamReturnNULL() throws Exception {
        List<Games> list = new LinkedList<>();
        Mockito.when(em.createQuery("SELECT e from Games e where e.name = :searching_name", Games.class).setParameter("searching_name", "Talizman").getResultList()).thenReturn(list);
        Assert.assertNull(dao.findGameByName("Sztos"));
    }


    @Test
    public void testRefreshGameWhenOpen() throws Exception {
        Games g = new Games();
        Mockito.when(em.isOpen()).thenReturn(true);
        dao.refreshGame(g);
        Mockito.verify(em).refresh(g);
    }
}