package services;

import model.dao.UserDao;
import model.entity.User;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 * @author asmolik
 */
@Path("hello")
@PermitAll
public class HelloService {
    @GET
    @Produces("text/plain")
    public String hello(@Context SecurityContext sc) {
        if (sc.isUserInRole("Customer")) {
            return "Hello customer " + sc.getUserPrincipal();
        } else if (sc.isUserInRole("admin")){
            return "Hello admin " + sc.getUserPrincipal();
        }
        return "Hello, World!!";
    }
}
