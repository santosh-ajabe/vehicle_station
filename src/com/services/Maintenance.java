package com.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Maintenance  {

    private List<String> maintenanceHistory;
    

    public Maintenance() {
        this.maintenanceHistory = new ArrayList<>();
    }

    public void addMaintenanceRecord(String record) {
        maintenanceHistory.add(record);
        System.out.println(record);
    }

    public void performMaintenance(String vehicleId) {
        String record = "Maintenance performed for Vehicle ID: " + vehicleId + " on " + new Date();
        addMaintenanceRecord(record);
    }

    public void performRepair(String vehicleId, String issueDetails) {
        String record = "Repair performed for Vehicle ID: " + vehicleId +
                " (Issue: " + issueDetails + ") on " + new Date();
        addMaintenanceRecord(record);
    }

    public void performOilChange(String vehicleId) {
        String record = "Oil change performed for Vehicle ID: " + vehicleId + " on " + new Date();
        addMaintenanceRecord(record);
    }

    public List<String> getMaintenanceHistory() {
        return maintenanceHistory;
    }

    public void viewMaintenanceHistory() {
        System.out.println("\n--- Maintenance History ---");
        if (maintenanceHistory.isEmpty()) {
            System.out.println("No maintenance history available.");
            return;
        }
        for (String record : maintenanceHistory) {
            System.out.println(record);
        }
    }

    public void getTodaysMaintenanceRecords() {
        String today = new Date().toString().substring(0, 10);
        System.out.println("\n--- Today's Maintenance Records ---");
        boolean found = false;
        for (String record : maintenanceHistory) {
            if (record.contains(today)) {
                System.out.println(record);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No records for today.");
        }
    }
}
