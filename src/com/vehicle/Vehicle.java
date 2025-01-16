package com.vehicle;

import java.io.Serializable;

public class Vehicle implements Serializable {
	private String manufacturer;
	private String model;
	private String vehicleNumber;

	public Vehicle(String manufacturer, String model, String vehicleNumber) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.vehicleNumber = vehicleNumber;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	@Override
	public String toString() {
		return "Vehicle{manufacturer='" + manufacturer + '\'' + ", model='" + model + '\'' + ", vehicleNumber='"
				+ vehicleNumber + '\'' + '}';
	}

	public void setVehicleNumber1(String nextLine) {
		
	}
}
