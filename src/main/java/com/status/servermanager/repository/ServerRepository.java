package com.status.servermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.status.servermanager.model.Server;

@Repository
public interface ServerRepository extends JpaRepository<Server, Long>{
	
	Server findByIpAddress(String ipAddress);
}
