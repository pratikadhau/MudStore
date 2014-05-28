package com.mudstore.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mudstore.model.Product;

@Path("/product/{id}")
public class ProductController {

	@GET
	@Produces(MediaType.TEXT_XML)
	public Product getProduct(@PathParam("id") Integer productId){
		return new Product(1, "food", "", 21.0);
	}
}
