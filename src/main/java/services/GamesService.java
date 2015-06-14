package services;

import model.client.Game;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author asmolik
 */

@Stateless
@Named
@Path("/games")
public class GamesService {

    private List<Game> allGames;
    private static final Logger logger = Logger.getLogger("services.GamesService");

    @PersistenceUnit(name = "persistenceUnit")
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Game> getAllGames() {
        EntityManager em = emf.createEntityManager();
        logger.info("Calling getAllGames");
        this.allGames = (List<Game>)
                em.createNamedQuery("model.entity.Games.getAllGames").getResultList();
        if (this.allGames == null) {
            logger.warning("No games available!");
        }
        em.close();
        return this.allGames;
    }

    public void setAllGames(List<Game> allGames) {
        this.allGames = allGames;
    }
}
