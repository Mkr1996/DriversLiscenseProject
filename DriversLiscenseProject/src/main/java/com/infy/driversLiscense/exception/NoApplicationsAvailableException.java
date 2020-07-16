package com.infy.driversLiscense.exception;

public class NoApplicationsAvailableException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NoApplicationsAvailableException(){
		super("No Applications Available");
	}

}
