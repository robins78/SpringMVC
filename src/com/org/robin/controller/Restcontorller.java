package com.org.robin.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/springRest")
public class Restcontorller {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
    	Response response = Response.ok().entity("From RestController").status(200).build(); 
    	 return  response;
    }

}
