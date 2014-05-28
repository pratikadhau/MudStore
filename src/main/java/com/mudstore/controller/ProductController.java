package com.mudstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mudstore.model.Product;
import com.mudstore.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/product/{id}")
	public ModelAndView getProduct(@PathVariable("id")Integer productId){
		Product product=productService.getProduct(productId);
		return new ModelAndView("Product","product",product);
	}
	
	@RequestMapping(value="/product/{id}/price")
	@ResponseBody
	public String getProductPrice(@PathVariable("id")Integer productId){
		return productService.getPrice(productId).toString();
	}
	
}
