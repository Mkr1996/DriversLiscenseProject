package com.infy.driversLiscense.exception;

public class ApplicationNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ApplicationNotFoundException(Integer applicationId)
	{
		super("Could not find a application with airport id: " + applicationId);
	}
}
