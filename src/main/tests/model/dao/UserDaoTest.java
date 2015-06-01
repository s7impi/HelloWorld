package model.dao;

import model.entity.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 * Testy dla klasy UserDAO
 * Created by Marz on 2015-06-01.
 */
public class UserDaoTest {

    Users user;
    UserDao dao;
    EntityManager em;
    UserTransaction ut;


    @Before
    public void setUp() throws Exception {
        user = new Users();
        user.setEmail("olek");
        user.setPassword("1234");
        em = Mockito.mock(EntityManager.class);
        ut = Mockito.mock(UserTransaction.class);
        dao = new UserDao(em, ut);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindUser() throws Exception {
        Mockito.when(em.find(Users.class, "olek")).thenReturn(user);
        Assert.assertSame(user, dao.findUser("olek"));
    }

    @Test
    public void testSaveIsOpenAndExecutePersistMetod() throws Exception {
        Mockito.when(em.isOpen()).thenReturn(true);
        dao.save(user);
        Mockito.verify(em).persist(user);
    }

    @Test(expected = TransactionNotOpenException.class)
    public void testSaveinNotOpenThrowException() throws Exception {
        Mockito.when(em.isOpen()).thenReturn(false);
        dao.save(user);
    }
}