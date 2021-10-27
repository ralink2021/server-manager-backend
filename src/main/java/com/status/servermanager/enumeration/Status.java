package com.status.servermanager.enumeration;

public enum Status {
	
	SERVER_UP("Servidor Online"), 
	SERVER_DOWN("Servidor Offline");
	
	private final String status;
	
	Status(String status){
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}
