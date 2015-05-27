package model.dao;

import model.entity.User;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author asmolik
 */
@Stateless
public class UserDao {
    @PersistenceContext
    EntityManager em;

    public User find(String name) {
        return em.find(User.class, name);
    }

    public void save(User user) {
        em.persist(user);
    }

    /**
     * Funkcja przeznaczona do testowania dzialania EntityMenagera i generalnie
     * hibernate'a. Mozna pisac tu glupoty.
     */
    public void test()
    {
        User us = new User();
        us.setEmail("ccc");
        us.setPassword("bbb");
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        session.save(us);
//        session.getTransaction().commit();
        em.persist(us);

    }
}
