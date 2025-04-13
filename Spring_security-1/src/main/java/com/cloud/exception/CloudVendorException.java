package com.cloud.exception;

import org.springframework.http.HttpStatus;

public class CloudVendorException {
	
	private final String message;
	private final Throwable throwable;
	private final HttpStatus status;
	public CloudVendorException(String message, Throwable throwable, HttpStatus status) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the throwable
	 */
	public Throwable getThrowable() {
		return throwable;
	}
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	

}
