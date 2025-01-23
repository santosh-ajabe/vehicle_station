package com.vehicle;

import java.io.Serializable;

public class Vehicle implements Serializable {
	private String vehicleNumber;
	private String type;
	private String ownerMobile;

	public Vehicle(String vehicleNumber, String type, String ownerMobile) {
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.ownerMobile = ownerMobile;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwnerMobile() {
		return ownerMobile;
	}

	public void setOwnerMobile(String ownerMobile) {
		this.ownerMobile = ownerMobile;
	}



	public String getRegistrationNumber() {

		return ownerMobile;
	}


	@Override
	public String toString() {
		return "Vehicle{" + "vehicleNumber='" + vehicleNumber + '\'' + ", type='" + type + '\'' + ", ownerMobile='"
				+ ownerMobile + '\'' + '}';
	}
	
}
