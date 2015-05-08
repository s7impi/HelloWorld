package services;

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
    @Produces("text/plain")
    public String login(@FormParam("mail") String mail, @FormParam("password") String password) {
        try {
            request.login(mail, password);
        } catch (ServletException e) {
            e.printStackTrace();
            return "error";
        }
        return "ok";
    }
}
