package com.matrimony.exception;

public class BADRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  BADRequestException(String exception) {
		super(exception);
	}
}
