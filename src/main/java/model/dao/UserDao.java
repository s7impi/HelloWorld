package model.dao;

import model.entity.User;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * @author asmolik
 */
@Stateless
public class UserDao {

    //@PersistenceContext(unitName = "persistenceUnit")
    private EntityManagerFactory emf;

    public User find(String name) {
        // return em.find(User.class, name);
        return null;
    }

    public void save(User user) {
        //em.persist(user);
    }

    /**
     * Funkcja przeznaczona do testowania dzialania EntityMenagera i generalnie
     * hibernate'a. Mozna pisac tu glupoty.
     */
    public String test() {
        User us = new User();
        us.setEmail("ccc");
        us.setPassword("bbb");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
        System.out.println("emf: " + emf.toString());
        System.out.println("em: " + em.toString());
        if (em.isOpen()) {
            User uss = em.find(User.class, "Olek");
            em.close();
            return uss.getPassword();
        } else {
            return "Closed";
        }
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        session.save(us);
//        session.getTransaction().commit();
    }
}
