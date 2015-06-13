package services;

import model.client.Game;

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
@Stateless
@Named
@Path("games/{gameID}")
public class GamesService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Game> getAllGames(@PathParam("gameID") String gameID) {
        List<Game> games = new ArrayList<>();
        Game game = new Game();
        game.setgameID(0);
        game.setName("Elysium");
        game.setSnippet("Mythic Greece. " + gameID);
        games.add(game);
        return games;
    }
}
