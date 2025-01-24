package com.vehicle;

import java.io.*;
import java.util.HashMap;

public class ManageVehicle {
    private HashMap<String, Vehicle> vehicles;
    private final String FILE_NAME = "vehicles.txt";

    public ManageVehicle() {
        vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleNumber(), vehicle);
        saveVehiclesToFile();
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
        Vehicle vehicle = vehicles.get(vehicleId);
        return (vehicle != null) ? vehicle.toString() : "Vehicle not found.";
    }

    public void saveVehiclesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(vehicles);
            System.out.println("Vehicle data saved successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving vehicle data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadVehiclesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            vehicles = (HashMap<String, Vehicle>) ois.readObject();
            System.out.println("Vehicle data loaded successfully from " + FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading vehicle data: " + e.getMessage());
        }
    }
}
