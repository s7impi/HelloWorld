package model.bean;

import model.entity.Game;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by s7impi on 23.05.15.
 */

@Stateless
@Named
@Path("/games")
public class GameBean {

    private List<Game> allGames;
    private static final Logger logger = Logger.getLogger("model.bean.GameBean");

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Game> getAllGames() {
        logger.info("Calling getAllGames");
        this.allGames = (List<Game>)
                em.createQuery("SELECT e from games e").getResultList();
        if (this.allGames == null) {
            logger.warning("No games available!");
        }
        return this.allGames;
    }

    public void setAllGames(List<Game> allGames) {
        this.allGames = allGames;
    }
}
