package services;

import javax.ws.rs.*;

/**
 * @author asmolik
 */
@Path("register")
public class RegisterService {
    @POST
    public void register(@FormParam("mail") String mail, @FormParam("password") String password,
                         @FormParam("name") String name) {

    }
}
