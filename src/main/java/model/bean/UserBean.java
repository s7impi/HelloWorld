package model.bean;

import model.entity.User;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author asmolik
 */
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 10)
public class UserBean implements Serializable {
    private User user;

    public int validate(String name, String password) {
        if (name.equals("asd") && password.equals("qwe"))
            return 0;
        return -1;
    }
    @RolesAllowed("Customer")
    public String getName() {
        return user.getEmail();
    }
}
