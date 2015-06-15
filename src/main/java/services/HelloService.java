package services;

import model.client.Game;
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
import java.util.ArrayList;
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
    public List<Game> hello(@Context SecurityContext sc) {
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

        List<Game> games = new ArrayList<>();
        for (Games ggg : list) {
            games.add(new Game(ggg));
        }

        return games;
    }
}
