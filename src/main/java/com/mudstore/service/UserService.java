package com.mudstore.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mudstore.model.User;

@Service
public class UserService {
	static Map<String,String> userNameMap=new HashMap<String,String>();
	static{
		userNameMap.put("prat", "Pratik Adhau");
	}

	public User getUserByUserName(String username) {
		User user = new User();
		user.setName(userNameMap.get(username));
		return user;
	}
	
}
