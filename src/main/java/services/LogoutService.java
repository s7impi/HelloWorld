package services;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

/**
 * @author asmolik
 */
@Path("logout")
@PermitAll
public class LogoutService {
    @GET
    public String logout(@Context HttpServletRequest request) {
        try {
            request.logout();
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        } catch (ServletException e) {
            e.printStackTrace();
            return "error";
        }
        return "ok";
    }
}
