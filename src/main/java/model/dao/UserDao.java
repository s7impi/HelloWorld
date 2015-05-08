package model.dao;

import model.entity.User;

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
}
