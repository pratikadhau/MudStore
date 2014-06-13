package com.mudstore.controller;

import com.mudstore.model.Product;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.core.MediaType;

@Controller
public class ProductControllerRestConsumer {

	@RequestMapping("product/restop/{id}")
	public ModelAndView getProduct(@PathVariable("id")Integer id){
//		RestTemplate  restTemplate=new RestTemplate();
//		Product product = restTemplate.getForObject("http://localhost:8080/MudStore/rest/product/"+id, Product.class);
		
		ClientConfig clientConfig=new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource resource = client.resource("http://localhost:8080/MudStore/rest/product/"+id);
		Product product=resource.accept(MediaType.APPLICATION_JSON).get(Product.class);
		ModelAndView modelAndView = new ModelAndView("Product","product",product);
		
		WebResource resource2 = client.resource("http://localhost:8080/MudStore/rest/product/");
		Builder builder = resource2.type(MediaType.APPLICATION_JSON);
		Product productResponse=builder.accept(MediaType.APPLICATION_JSON).post(Product.class,product);
		System.out.println(productResponse);
//		RestTemplate  restTemplate=new RestTemplate();
//		Response response=restTemplate.postForObject("http://localhost:8080/MudStore/rest/product/", product, Response.class);
		
		return modelAndView;
	}
	
}
