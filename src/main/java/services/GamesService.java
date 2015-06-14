package services;

import model.client.Game;
import model.dao.GameDAO;
import model.entity.Games;

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
@Path("games/{gameName}")
public class GamesService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Games> getGame(@PathParam("gameName") String gameName) {
        GameDAO dao = new GameDAO();
        List<Games> game = dao.findGameByName(gameName);
        return game;
    }
}
