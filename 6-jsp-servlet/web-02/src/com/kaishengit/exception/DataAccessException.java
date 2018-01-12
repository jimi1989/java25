package com.kaishengit.exception;

public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataAccessException(String message) {
		super(message);
	}
	
	public DataAccessException(Throwable th) {
		super(th);
	}
	
	public DataAccessException(String message, Throwable th) {
		super(message,th);
	}
}
