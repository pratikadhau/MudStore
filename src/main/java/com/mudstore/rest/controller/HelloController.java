package com.mudstore.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/hello")
public class HelloController {

	@GET
	@Produces(value=MediaType.TEXT_PLAIN)
	public String sayHello(){
		return "Hello Jersey";
	}
}
