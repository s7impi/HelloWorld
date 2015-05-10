package services;

import model.entity.User;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
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
    public String login(User user) {
        try {
            request.login(user.getEmail(), user.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
            return "error";
        }
        return "ok";
    }
}
