package services;

import model.dao.CategoryDAO;
import model.dao.GameDAO;
import model.dao.UserDao;
import model.entity.Category;
import model.entity.Game;
import model.entity.User;

import javax.annotation.security.PermitAll;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

/**
 * @author asmolik
 */
@Path("hello")
@PermitAll
public class HelloService {
    private String napis = "";

    @GET
    @Produces("text/plain")
    public String hello(@Context SecurityContext sc) {
        GameDAO dao = new GameDAO();
        List<Game> list = dao.findAllGames();
        for(Game c: list)
        {
            napis = napis + " " + c.getName();
        }
        return napis;
    }
}
