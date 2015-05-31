package services;

import model.dao.GameDAO;
import model.entity.Games;

import javax.annotation.security.PermitAll;
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
        Games g = dao.findGame(1);

        List<Games> list = dao.findAllGames();
        for (Games c : list)
        {
            napis = napis + " " + c.getName();
        }
        return "done";//g.getCategory().getDescription();
    }
}
