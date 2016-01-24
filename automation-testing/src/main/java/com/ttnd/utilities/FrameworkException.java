package com.ttnd.utilities;

public class FrameworkException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String message = null;
	 
	 public FrameworkException() {
		 
	        super();
	    }
	
	public FrameworkException(String strMessage) {
		super(strMessage);
		this.message = strMessage;
	}
	
	public FrameworkException(String strExceptionMessage, Throwable tExceptionMessage) {
		super(strExceptionMessage, tExceptionMessage);
	}
	
	@Override
	public String toString() {
		return message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}	
}
