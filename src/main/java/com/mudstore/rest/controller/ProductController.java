package com.mudstore.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mudstore.model.Product;
import com.mudstore.service.ProductService;

@Component
@Path("/product/{id}")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Product getProduct(@PathParam("id") Integer productId){
		return productService.getProduct(productId);
	}
}
