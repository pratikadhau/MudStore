package com.mudstore.service;

import org.springframework.stereotype.Service;

import com.mudstore.exception.InvalidCredential;
import com.mudstore.model.Credential;

@Service
public class LoginService {

	public Credential login(Credential credential) throws InvalidCredential{
		if(credential.getUsername().equalsIgnoreCase("pratik")&&credential.getPassword().equals("adhau")){
			Credential credential2 = new Credential();
			credential2.setUsername("pratik");
			return credential2;
		}else{
			throw new InvalidCredential("Invalid password");
		}
	}
	
	
}
