package com.mudstore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mudstore.model.Product;

@Service
public class ProductService {
	private static Map<Integer, Product> productMap;
	static{
		productMap=new HashMap<Integer, Product>();
		productMap.put(1,new Product(1,"Watch","Accessory",850.0));
		productMap.put(2,new Product(2,"Paracetemol","Medcine",5.0));
		productMap.put(3,new Product(3,"Pizza","Food",850.0));
	}

	public List<Product> getAllProducts() {
		List<Product> productList=new ArrayList<Product>();
		for (Product product : productMap.values()) {
			productList.add(product);
		}	
		return productList;
	}

	public Product getProduct(Integer productId) {
		return productMap.get(productId);
	}

	public Double getPrice(Integer productId) {
		return productMap.get(productId).getPrice();
	}
}
