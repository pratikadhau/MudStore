package com.mudstore.rest.controller;

import java.util.List;

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
@Path("/product")
public class ProductRestController {
	@Autowired
	ProductService productService;
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("{id}")
	public Product getProduct(@PathParam("id") Integer productId){
		return productService.getProduct(productId);
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Product> getAllProduct(){
		return productService.getAllProducts();
	}
}
