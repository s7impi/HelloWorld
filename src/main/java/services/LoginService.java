package services;

import model.entity.Users;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

/**
 * @author asmolik
 */
@Path("login")
@PermitAll
public class LoginService {
    @Context
    HttpServletRequest request;

    @POST
    @Consumes({"application/json", "text/plain"})
    @Produces("text/plain")
    public String login(Users user) {
        try {
            request.login(user.getEmail(), user.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
            return "error";
        }
        return "ok";
    }
}
