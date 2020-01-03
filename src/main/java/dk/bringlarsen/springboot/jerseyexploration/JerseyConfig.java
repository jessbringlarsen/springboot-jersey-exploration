package dk.bringlarsen.springboot.jerseyexploration;


import dk.bringlarsen.springboot.jerseyexploration.resources.GameOfThronesResource;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerResources();
    }

    private void registerResources() {
        register(GameOfThronesResource.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }

    @PostConstruct
    public void init() {
        configureSwagger();
    }

    private void configureSwagger() {
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setVersion("v1");
        config.setSchemes(new String[] { "http", "https" });
        config.setBasePath("/api");
        config.setResourcePackage("dk.bringlarsen.springboot.jerseyexploration.resources");
        config.setPrettyPrint(true);
        config.setScan(true);
    }
}
