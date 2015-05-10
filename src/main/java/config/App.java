package config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

/**
 * @author asmolik
 */
@ApplicationPath("/api")
public class App extends ResourceConfig {
    public App() {
        packages("services");
        register(RolesAllowedDynamicFeature.class);
    }
}
