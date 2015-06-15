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

@Path("games/{gameID}")
@PermitAll
public class GamesService {

    @GET
    @Produces("application/json")
    public List<Game> getAllGames(@PathParam("gameID") String gameID) {
        List<Game> games = new ArrayList<>();
        GameDAO dao = new GameDAO();
        List<Games> list;
        if (gameID.equals("boardgames")) {
            list = dao.findAllGames();
            for (Games ggg : list) {
                games.add(new Game(ggg));
            }
        }
        else {
            int id = Integer.parseInt(gameID);
            list = new ArrayList<>();
            list.add(dao.findGame(id));
            for (Games ggg : list) {
                games.add(new Game(ggg));
            }
        }
        return games;
    }
}
