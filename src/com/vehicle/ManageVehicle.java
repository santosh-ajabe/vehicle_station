package com.vehicle;

import java.util.*;

import com.customer.ManageCustomer;

public class ManageVehicle {
    private HashMap<String, Vehicle> vehicles; 

    public ManageVehicle() {
        vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleNumber(), vehicle);
    }

    public void deleteVehicle(String vehicleNumber) {
        vehicles.remove(vehicleNumber);
    }

    public Vehicle getVehicle(String vehicleNumber) {
        return vehicles.get(vehicleNumber);
    }

    public void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            vehicles.values().forEach(System.out::println);
        }
    }

	public void displayCustomerVehicles(String searchMobile, ManageCustomer manageCustomer) {
		// TODO Auto-generated method stub
		
	}
}