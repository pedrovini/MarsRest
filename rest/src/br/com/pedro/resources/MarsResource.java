package br.com.pedro.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.pedro.math.CalculatePosition;

@Path("/mars")
public class MarsResource {
	
	@GET
	@Path("{coordinate}")
	@Produces("text/plain")
	public String getPosition(@PathParam("coordinate") String coordinate) {
		return new CalculatePosition().calculatePosition(coordinate);
	}
	
	@POST
	@Path("{coordinate}")
	@Consumes("text/plain")
	public String postPosition(@PathParam("coordinate") String coordinate) {
		return new CalculatePosition().calculatePosition(coordinate);
	}
	
} 
