package services;

import model.client.Game;
import model.dao.GameDAO;
import model.entity.Games;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author asmolik
 */

@Path("games")
@PermitAll
public class GamesService {

    @GET
    @Path("/boardgames")
    @Produces("application/json")
    public List<Game> getAllGames(@PathParam("gameID") String gameID) {
        List<Game> games = new ArrayList<>();
        GameDAO dao = new GameDAO();
        List<Games> list;
        list = dao.findAllGames();
        for (Games ggg : list) {
            games.add(new Game(ggg));
        }

        return games;
    }

    @GET
    @Path("/{gameID}")
    @Produces("application/json")
    public Game getGame(@PathParam("gameID") String gameID) {
        GameDAO dao = new GameDAO();
        int id = Integer.parseInt(gameID);
        Game game = new Game(dao.findGame(id));

        return game;
    }

}
