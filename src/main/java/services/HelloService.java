package services;

import model.dao.CategoryDAO;
import model.dao.UserDao;
import model.entity.Category;
import model.entity.User;

import javax.annotation.security.PermitAll;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

/**
 * @author asmolik
 */
@Path("hello")
@PermitAll
public class HelloService {
    private String napis;

    @GET
    @Produces("text/plain")
    public String hello(@Context SecurityContext sc) {
        CategoryDAO dao = new CategoryDAO();
        List<Category> list = dao.getAllCategories();
        for(Category c: list)
        {
            napis = napis + " " + c.getName();
        }
        return napis;
    }
}
