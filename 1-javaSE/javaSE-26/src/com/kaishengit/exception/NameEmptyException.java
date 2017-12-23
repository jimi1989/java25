package com.kaishengit.exception;

public class NameEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NameEmptyException(){}
	
	public NameEmptyException(String msg) {
		super(msg);
	}
	
}
