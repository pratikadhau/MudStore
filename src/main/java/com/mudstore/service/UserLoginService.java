package com.mudstore.service;

import org.springframework.stereotype.Service;

import com.mudstore.model.Credential;

@Service
public class UserLoginService {

	public Boolean isValid(Credential credential) {
		return true;
	}
	
	
}
