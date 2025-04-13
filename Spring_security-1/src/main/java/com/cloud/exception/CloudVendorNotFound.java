package com.cloud.exception;

public class CloudVendorNotFound extends Exception {

	public CloudVendorNotFound(String message) {
		super(message);
	}
	
	public  CloudVendorNotFound(String message,Throwable throwable) {
		super(message,throwable);
	}
}
