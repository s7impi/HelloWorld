package services;

import model.dao.GameDAO;
import model.dao.TransactionNotOpenException;
import model.entity.Game;

import javax.annotation.security.PermitAll;
import javax.transaction.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 * @author asmolik
 */
@Path("hello")
@PermitAll
public class HelloService {

    @GET
    @Produces("text/plain")
    public String hello(@Context SecurityContext sc) {
        GameDAO dao = new GameDAO();
        Game g =new Game("Konan","RPG","bardzo ciekawa gra");
        try {
            dao.insertGame(g);
        } catch (SystemException | NotSupportedException | HeuristicRollbackException | HeuristicMixedException | TransactionNotOpenException | RollbackException e) {
            e.printStackTrace();
        }
        return "done!!!!";
    }
}
