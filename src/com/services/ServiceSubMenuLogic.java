package com.services;

import com.customer.*;
import com.customer.Customer;
import com.parts.PartManager;
import com.vehicle.*;
import com.vehicle.Vehicle;
import com.demo.services.*;

import java.util.Scanner;

public class ServiceSubMenuLogic {

    public void handleServiceRequestMenu(Scanner scanner, ManageServices manageServices, ManageCustomer manageCustomer, ManageVehicle manageVehicle, PartManager partManager) {
        while (true) {
            System.out.println("\n--- Service Menu ---");
            System.out.println("1. Maintenance Service");
            System.out.println("2. Repairing Service");
            System.out.println("3. Oil Change Service");
            System.out.println("4. Show Existing Services");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 0:
                    return;
                case 1:
                    maintenanceService(scanner, manageCustomer, manageVehicle, manageServices);
                    break;
                case 2:
                    repairingService(scanner, manageCustomer, manageVehicle, manageServices);
                    break;
                case 3:
                    oilChangeService(scanner, manageCustomer, manageVehicle, manageServices);
                    break;
                case 4:
                    showExistingServices(manageServices);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void maintenanceService(Scanner scanner, ManageCustomer manageCustomer, ManageVehicle manageVehicle, ManageServices manageServices) {
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

        System.out.print("Enter the cost of maintenance parts: ");
        double partsCost = scanner.nextDouble();
        System.out.print("Enter the labor charges: ");
        double laborCharges = scanner.nextDouble();

        double totalCost = partsCost + laborCharges;
        double gst = totalCost * 0.125;
        double finalBill = totalCost + gst;

        System.out.println("\n--- Bill Details ---");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Vehicle Registration: " + vehicle.getRegistrationNumber());
        System.out.println("Parts Cost: " + partsCost);
        System.out.println("Labor Charges: " + laborCharges);
        System.out.println("GST (12.5%): " + gst);
        System.out.println("Total Bill: " + finalBill);

        Service service = new Service("Maintenance", customer.getMobileNumber(), vehicle.getRegistrationNumber(), "Completed");
        manageServices.addService(service);
        System.out.println("Maintenance service completed and recorded.");
    }

    private void repairingService(Scanner scanner, ManageCustomer manageCustomer, ManageVehicle manageVehicle, ManageServices manageServices) {
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

        System.out.println("Performing Repairing Service...");
        System.out.println("Repairing: " + repairDescription);

        Service service = new Service("Repairing", customer.getMobileNumber(), vehicle.getRegistrationNumber(), "Completed");
        manageServices.addService(service);
        System.out.println("Repairing service completed and recorded.");
    }

    private void oilChangeService(Scanner scanner, ManageCustomer manageCustomer, ManageVehicle manageVehicle, ManageServices manageServices) {
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

        double gst = oilCost * 0.125;
        double finalBill = oilCost + gst;

        System.out.println("\n--- Bill Details ---");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Vehicle Registration: " + vehicle.getRegistrationNumber());
        System.out.println("Oil Cost: " + oilCost);
        System.out.println("GST (12.5%): " + gst);
        System.out.println("Total Bill: " + finalBill);

        Service service = new Service("Oil Change", customer.getMobileNumber(), vehicle.getRegistrationNumber(), "Completed");
        manageServices.addService(service);
        System.out.println("Oil change service completed and recorded.");
    }

    private void showExistingServices(ManageServices manageServices) {
        System.out.println("\n--- Existing Services ---");
        manageServices.displayAllServices();
    }
}
