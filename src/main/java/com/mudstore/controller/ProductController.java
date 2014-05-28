package com.mudstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mudstore.model.Product;

@Controller
public class ProductController {

	@RequestMapping(value="/product/{id}")
	public ModelAndView getProduct(@PathVariable("id")Integer productId){
		Product product;
		switch (productId) {
		case 1:
			product=new Product(1,"Watch","Accessory",850.0);
			break;
		case 2:
			product=new Product(2,"Paracetemol","Medcine",5.0);
			break;
		case 3:
			product=new Product(3,"Pizza","Food",500.0);
			break;

		default:
			product=new Product(-1,"","",0.0);
			break;
		}
		return new ModelAndView("Product","product",product);
	}
}
