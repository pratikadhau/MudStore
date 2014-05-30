package com.mudstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class CartController {
	@RequestMapping(value="/cart1",method=RequestMethod.POST)
	@ResponseBody
	public String addProductToCart(@RequestParam("productId")Integer productId,@RequestParam("cartId") Integer cartId){
		System.out.println("Product "+productId+ " is added to cart "+cartId);
		return "successfull";
	}
}
