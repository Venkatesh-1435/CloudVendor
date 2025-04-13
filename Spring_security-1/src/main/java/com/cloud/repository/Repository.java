package com.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.Entity.CloudVendor;

public interface Repository extends JpaRepository<CloudVendor,String> {

}
