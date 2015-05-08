package services;

import model.dao.UserDao;
import model.entity.User;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * @author asmolik
 */
@Path("register")
@PermitAll
public class RegisterService {
    @Inject
    UserDao dao;

    @POST
    public String register(@FormParam("mail") String mail, @FormParam("password") String password,
                         @FormParam("name") String name) {
        User user = new User(mail, password);
        dao.save(user);
        return "ok";
    }
}
