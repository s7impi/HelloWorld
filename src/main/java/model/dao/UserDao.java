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
        UserDaoDB udao = new UserDaoDBImpl();
        UserDB udb = udao.findByUserName(name);
        if (udb == null)
            return null;

        if (name.equals(udb.getName()) && password.equals(udb.getPassword())) {
            user = new User(name);
        }
        return user;
    }


}
