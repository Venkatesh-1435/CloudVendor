package com.cloud.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cloud.Entity.CloudVendor;
import com.cloud.exception.CloudVendorNotFound;
import com.cloud.repository.Repository;

@Service
public class CloudService {
	
	public final Repository repo;
	
	public CloudService(Repository repo){
		this.repo=repo;	
	}
	
	public CloudVendor getById(String vendorId) throws CloudVendorNotFound {
		Optional<CloudVendor> vendor=repo.findById(vendorId);
		if(vendor.isEmpty())
			throw new CloudVendorNotFound("Vendor not found by these ID");
		return vendor.get();
	}
	
	public boolean createVendor(CloudVendor vendor) {
		CloudVendor create=repo.save(vendor);
		if(create!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	public java.util.List<CloudVendor> getAll(){
		return repo.findAll();	
	}
	
	public CloudVendor updateVendor(String id,CloudVendor vendor) throws CloudVendorNotFound {
		Optional<CloudVendor> Oldvendor=repo.findById(id);
		if(Oldvendor.isPresent()) {
			CloudVendor c=Oldvendor.get();
			c.setVendorName(vendor.getVendorName());
			c.setVendorAddress(vendor.getVendorAddress());
			c.setVendorPhoneNumber(vendor.getVendorPhoneNumber());
			return repo.save(c);
		}else {
			throw new CloudVendorNotFound("Vendor not found by these ID");
		}
		
	}
	
	public void deleteVendor(String id) throws CloudVendorNotFound {
		Optional<CloudVendor> Oldvendor=repo.findById(id);
		if(Oldvendor.isPresent()) {
			 repo.deleteById(id);
		}else {
			throw new CloudVendorNotFound("Vendor not found by these ID");
		}
		
	}

}
