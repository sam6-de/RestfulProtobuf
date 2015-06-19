package de.sam6.demo.microservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: Sascha
 * Date: 19.06.2015
 * Time: 17:42
 */
@Path("/hello")
public class HelloWorldService {
    @GET
    @Path("/{param}")
    @Produces("text/plain")
    public Response getName(@PathParam("param") String name) {
        String output = "Hello, " + name + "!";
        return Response.status(200).entity(output).build();
    }
}
