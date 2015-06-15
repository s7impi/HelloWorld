package services;

import model.dao.GameDAO;
import model.dao.TransactionNotOpenException;
import model.entity.Games;

import javax.annotation.security.PermitAll;
import javax.transaction.*;
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
    @Produces("application/json")
    public String hello(@Context SecurityContext sc) {
        GameDAO dao = new GameDAO();
        Games g = new Games();
        g.setShortDescription("oto gra");
        g.setName("Pan");
        g.setPrice((float) 10);
        g.setCategoriesName("RPG");


        List<Games> list = dao.findAllGames();
        for (Games c : list)
        {
            napis = napis + " " + c.getShortDescription();
        }
        return napis;//g.getCategory().getDescription();
    }
}
