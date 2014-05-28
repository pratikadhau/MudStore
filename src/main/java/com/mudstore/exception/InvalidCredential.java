package com.mudstore.exception;

@SuppressWarnings("serial")
public class InvalidCredential extends RuntimeException{

	public InvalidCredential(String msg) {
		super(msg);
	}

}
