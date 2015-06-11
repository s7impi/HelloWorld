package model.bean;

import model.entity.Games;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by s7impi on 23.05.15.
 */

@Stateless
@Named
@Path("/games")
public class GameBean {

    private List<Games> allGames;
    private static final Logger logger = Logger.getLogger("model.bean.GameBean");

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Games> getAllGames() {
        logger.info("Calling getAllGames");
        this.allGames = em.createQuery("SELECT e from Games e", Games.class).getResultList();
        if (this.allGames == null) {
            logger.warning("No games available!");
        }
        return this.allGames;
    }

    public void setAllGames(List<Games> allGames) {
        this.allGames = allGames;
    }
}
