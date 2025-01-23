package com.vehicle;

import java.util.HashMap;

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

	public String getVehicleDetailsById(String vehicleId) {
		return vehicleId;
	}
}
