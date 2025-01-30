package com.services;

import com.customer.Customer;
import com.customer.ManageCustomer;
import com.parts.PartManager;
import com.vehicle.ManageVehicle;
import com.vehicle.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceSubMenuLogic {
    private final List<String> billEntries = new ArrayList<>();
    private double totalLaborCharges = 0.0;
    private double totalOilCost = 0.0;

    public void handleServiceRequestMenu(Scanner scanner, ManageServices manageServices, ManageCustomer manageCustomer, ManageVehicle manageVehicle, PartManager partManager) {
        while (true) {
            System.out.println("\n--- Service Menu ---");
            System.out.println("1. Maintenance Service");
            System.out.println("2. Repairing Service");
            System.out.println("3. Oil Change Service");
            System.out.println("4. Prepare and Display Bill");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 0:
                    return;
                case 1:
                    maintenanceService(scanner, manageCustomer, manageVehicle);
                    break;
                case 2:
                    repairingService(scanner, manageCustomer, manageVehicle);
                    break;
                case 3:
                    oilChangeService(scanner, manageCustomer, manageVehicle);
                    break;
                case 4:
                    generateAndDisplayBill();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void maintenanceService(Scanner scanner, ManageCustomer manageCustomer, ManageVehicle manageVehicle) {
        System.out.println("\n--- Maintenance Service ---");
        System.out.print("Enter customer mobile number: ");
        String mobileNumber = scanner.nextLine().trim();
        Customer customer = manageCustomer.getCustomer(mobileNumber);

        if (customer == null) {
            System.out.println("Customer not found for mobile number: " + mobileNumber);
            return;
        }

        System.out.print("Enter vehicle registration number: ");
        String vehicleNumber = scanner.nextLine().trim();
        Vehicle vehicle = manageVehicle.getVehicle(vehicleNumber);

        if (vehicle == null) {
            System.out.println("Vehicle not found for registration number: " + vehicleNumber);
            return;
        }

        System.out.print("What is done in maintenance: ");
        String maintenanceTask = scanner.nextLine();
        System.out.print("Enter the labour charges: ");
        double laborCharges = scanner.nextDouble();
        scanner.nextLine(); 

        totalLaborCharges += laborCharges;
        billEntries.add("Customer: " + customer.getName() + ", Vehicle: " + vehicle.getRegistrationNumber() + ", Service: Maintenance, Labour Charges: " + laborCharges);
    }

    private void repairingService(Scanner scanner, ManageCustomer manageCustomer, ManageVehicle manageVehicle) {
        System.out.println("\n--- Repairing Service ---");
        System.out.print("Enter customer mobile number: ");
        String mobileNumber = scanner.nextLine().trim();
        Customer customer = manageCustomer.getCustomer(mobileNumber);

        if (customer == null) {
            System.out.println("Customer not found for mobile number: " + mobileNumber);
            return;
        }

        System.out.print("Enter vehicle registration number: ");
        String vehicleNumber = scanner.nextLine().trim();
        Vehicle vehicle = manageVehicle.getVehicle(vehicleNumber);

        if (vehicle == null) {
            System.out.println("Vehicle not found for registration number: " + vehicleNumber);
            return;
        }

        System.out.print("Enter repair description: ");
        String repairDescription = scanner.nextLine();
        System.out.print("Enter the labour charges: ");
        double laborCharges = scanner.nextDouble();
        scanner.nextLine(); 

        totalLaborCharges += laborCharges;
        billEntries.add("Customer: " + customer.getName() + ", Vehicle: " + vehicle.getRegistrationNumber() + ", Service: Repairing, Labour Charges: " + laborCharges + ", Description: " + repairDescription);
    }

    private void oilChangeService(Scanner scanner, ManageCustomer manageCustomer, ManageVehicle manageVehicle) {
        System.out.println("\n--- Oil Change Service ---");
        System.out.print("Enter customer mobile number: ");
        String mobileNumber = scanner.nextLine().trim();
        Customer customer = manageCustomer.getCustomer(mobileNumber);

        if (customer == null) {
            System.out.println("Customer not found for mobile number: " + mobileNumber);
            return;
        }

        System.out.print("Enter vehicle registration number: ");
        String vehicleNumber = scanner.nextLine().trim();
        Vehicle vehicle = manageVehicle.getVehicle(vehicleNumber);

        if (vehicle == null) {
            System.out.println("Vehicle not found for registration number: " + vehicleNumber);
            return;
        }

        System.out.print("Enter the cost of oil: ");
        double oilCost = scanner.nextDouble();
        scanner.nextLine(); 

        totalOilCost += oilCost;
        billEntries.add("Customer: " + customer.getName() + ", Vehicle: " + vehicle.getRegistrationNumber() + ", Service: Oil Change, Oil Cost: " + oilCost);
    }

    private void generateAndDisplayBill() {
        double totalAmount = totalLaborCharges + totalOilCost;
        double gst = totalAmount * 0.125;
        double finalAmount = totalAmount + gst;

        System.out.println("\n--- Final Bill ---");
        System.out.println("Total Labour Charges: " + totalLaborCharges);
        System.out.println("Total Oil Cost: " + totalOilCost);
        System.out.println("Total Before GST: " + totalAmount);
        System.out.println("GST (12.5%): " + gst);
        System.out.println("Total Bill Amount: " + finalAmount);

        try (FileWriter writer = new FileWriter("bills.txt", true)) {
            writer.write("Total Labour Charges: " + totalLaborCharges + "\n");
            writer.write("Total Oil Cost: " + totalOilCost + "\n");
            writer.write("Total Before GST: " + totalAmount + "\n");
            writer.write("GST (12.5%): " + gst + "\n");
            writer.write("Total Bill Amount: " + finalAmount + "\n");
            writer.write("-------------------------------------\n");
        } catch (IOException e) {
            System.out.println("Error saving bill: " + e.getMessage());
        }

        totalLaborCharges = 0.0;
        totalOilCost = 0.0;
        billEntries.clear();
    }
}
