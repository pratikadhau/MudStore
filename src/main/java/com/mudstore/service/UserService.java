package com.mudstore.service;

import org.springframework.stereotype.Service;

import com.mudstore.model.Credential;
import com.mudstore.model.User;

@Service
public class UserService {

	public User getUserByUserName(Credential loginUserCredential) {
		User user = new User();
		user.setName(loginUserCredential.getUsername());
		return user;
	}
	
}
