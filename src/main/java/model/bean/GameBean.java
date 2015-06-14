package model.bean;

import model.client.Game;
import model.entity.Games;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by s7impi on 23.05.15.
 */

@Stateless
@Named
@Path("/games/{gameID}")
public class GameBean {

    private List<Games> allGames;
    private static final Logger logger = Logger.getLogger("model.bean.GameBean");

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Game> getAllGames(@PathParam("gameID") String gameID) {
//        logger.info("Calling getAllGames");
//        this.allGames = em.createQuery("SELECT e from Games e", Games.class).getResultList();
//        if (this.allGames == null) {
//            logger.warning("No games available!");
//        }
//        return this.allGames;

        List<Game> games = new ArrayList<>();
        Game game = new Game();
        game.setId(0);
        game.setName("Elysium");
        game.setSnippet("Mythic Greece.");
        games.add(game);
        return games;
    }

    public void setAllGames(List<Games> allGames) {
        this.allGames = allGames;
    }
}
