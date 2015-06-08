package services;

import model.dao.TransactionNotOpenException;
import model.dao.UserDao;
import model.entity.Users;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
        Users user = new Users();
        user.setPassword(password);
        user.setEmail(name);
        try {
            dao.save(user);
        } catch (SystemException | javax.transaction.NotSupportedException | HeuristicMixedException | RollbackException | HeuristicRollbackException | TransactionNotOpenException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
