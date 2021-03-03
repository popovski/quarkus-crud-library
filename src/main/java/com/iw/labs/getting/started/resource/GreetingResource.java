package com.iw.labs.getting.started.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.iw.labs.getting.started.service.GreetingService;

@Path("/hello")
public class GreetingResource {
	@Inject
	GreetingService service;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return service.greeting();
    }
}