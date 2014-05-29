package com.mudstore.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mudstore.model.Product;
import com.mudstore.service.ProductService;

@Component
@Path("/product")
public class ProductRestController {
	@Autowired
	ProductService productService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Product getProduct(@PathParam("id") Integer productId){
		return productService.getProduct(productId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllProduct(Product product){
		System.out.println(product);
		System.out.println("success");
		return Response.status(200).entity(null).build();
	}
}
