package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.Entity.CloudVendor;
import com.cloud.Entity.ResponseHandler;
import com.cloud.exception.CloudVendorNotFound;
import com.cloud.service.CloudService;

@RestController
@RequestMapping("/cloudvendor")
public class Controller {
	
	@Autowired
	private CloudService service;
	
	@GetMapping("/{cloudVendorId}")
	public ResponseEntity<Object> getCloudVendor( @PathVariable String cloudVendorId) throws CloudVendorNotFound{
		return ResponseHandler.responseBuilder("Required details", HttpStatus.OK, service.getById(cloudVendorId));
		 
	}
	
	@PostMapping
	public ResponseEntity<?> createVendor(@RequestBody CloudVendor vendor){
		boolean flag=service.createVendor(vendor);
		if(flag) {
			return new ResponseEntity<>("Vendor Created Succesfully",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Not created",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseHandler.responseBuilder("All vendor details", HttpStatus.OK, service.getAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateVendor( @PathVariable String id, @RequestBody CloudVendor vendor) throws CloudVendorNotFound{
		return new ResponseEntity<>(service.updateVendor(id, vendor),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteVendor(@PathVariable String id) throws CloudVendorNotFound{
		service.deleteVendor(id);
		return new ResponseEntity<>("Deleted Succesfully",HttpStatus.OK);
	}
	
	
}
