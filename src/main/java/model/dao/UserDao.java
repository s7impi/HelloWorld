package model.dao;

import model.entity.User;

import javax.ejb.Stateless;

/**
 * @author asmolik
 */
@Stateless
public class UserDao {
    public User find(String name, String password) {
        User user = null;
        if (name.equals("asd") && password.equals("qwe")) {
            user = new User(name);
        }
        return user;
    }
}
