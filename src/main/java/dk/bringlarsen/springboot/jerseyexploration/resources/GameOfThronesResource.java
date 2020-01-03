package dk.bringlarsen.springboot.jerseyexploration.resources;

import com.github.javafaker.Faker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;

@Component
@Path("/api/gameofthrones")
@Api(value = "Game Of Thrones resource - It's all about Game Of Thrones!", produces = MediaType.TEXT_PLAIN)
public class GameOfThronesResource {

    @GET
    @Path("/quotes")
    @ApiOperation(value = "Get a random quote", response = String.class)
    @ApiResponse(code = 200, message = "Enjoy your quote!")
    public Response getRandomQuote() {
        return Response.ok(new Faker(new Random()).gameOfThrones().quote()).build();
    }

    @GET
    @Path("/characters")
    @ApiOperation(value = "Get a random character", response = String.class)
    @ApiResponse(code = 200, message = "Enjoy your character!")
    public Response getRandomCharacter() {
        return Response.ok(new Faker(new Random()).gameOfThrones().character()).build();
    }
}
