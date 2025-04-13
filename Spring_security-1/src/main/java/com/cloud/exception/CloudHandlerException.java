package com.cloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudHandlerException {
	
	@ExceptionHandler(value= {CloudVendorNotFound.class})
	public ResponseEntity<?> cloudHandlerException(CloudVendorNotFound exe){
		CloudVendorException vendorException=
				new CloudVendorException(exe.getMessage(),exe.getCause(),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(vendorException,HttpStatus.NOT_FOUND);
	}

}
