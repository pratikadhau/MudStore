package com.mudstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mudstore.model.Product;

@Service
public class ProductService {

	public List<Product> getAllProducts() {
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1,"Watch","Accessory",850.0));
		productList.add(new Product(2,"Paracetemol","Medcine",5.0));
		productList.add(new Product(3,"Pizza","Food",850.0));
		return productList;
	}

}
