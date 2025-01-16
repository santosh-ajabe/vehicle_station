package com.services;

import java.util.*;

public class Bill {
    private String serviceStationName;
    private Date serviceDate;
    private String customerName;
    private String vehicleDetails;
    private List<String> sparePartDetails;
    private double maintenanceCharges;
    private double oilCharges;
    private double gstPercentage;
    private double totalAmount;

    public Bill(String serviceStationName, Date serviceDate, String customerName, String vehicleDetails) {
        this.serviceStationName = serviceStationName;
        this.serviceDate = serviceDate;
        this.customerName = customerName;
        this.vehicleDetails = vehicleDetails;
        this.sparePartDetails = new ArrayList<>();
        this.maintenanceCharges = 0.0;
        this.oilCharges = 0.0;
        this.gstPercentage = 12.5;
        this.totalAmount = 0.0;
    }

    public void addSparePart(String partName, double partCost) {
        sparePartDetails.add(partName + " - " + partCost);
        totalAmount += partCost;
    }

    public void setMaintenanceCharges(double charges) {
        this.maintenanceCharges = charges;
        totalAmount += charges;
    }

    public void setOilCharges(double charges) {
        this.oilCharges = charges;
        totalAmount += charges;
    }

    public double calculateGST() {
        return (totalAmount * gstPercentage) / 100;
    }

    public double calculateFinalAmount() {
        return totalAmount + calculateGST();
    }

    public void displayBill() {
        System.out.println("----- Bill Details -----");
        System.out.println("Service Station: " + serviceStationName);
        System.out.println("Service Date: " + serviceDate);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Vehicle Details: " + vehicleDetails);
        System.out.println("\n--- Spare Part Details ---");
        for (String detail : sparePartDetails) {
            System.out.println(detail);
        }
        System.out.println("\nMaintenance Charges: " + maintenanceCharges);
        System.out.println("Oil Charges: " + oilCharges);
        System.out.println("Total Amount (Before GST): " + totalAmount);
        System.out.println("GST (" + gstPercentage + "%): " + calculateGST());
        System.out.println("Final Bill Amount: " + calculateFinalAmount());
    }
}
