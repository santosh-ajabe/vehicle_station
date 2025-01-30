package com.services;

import com.customer.Customer;
import com.customer.ManageCustomer;
import com.parts.PartManager;
import com.vehicle.ManageVehicle;
import com.vehicle.Vehicle;
import java.io.*;
import java.util.*;

public class ServiceSubMenuLogic {
    private final List<String> billEntries = new ArrayList<>();
    private double totalLaborCharges = 0.0;
    private double totalOilCost = 0.0;
    private String selectedVehicleNumber = "";
    private String customerMobileNumber = "";

    public void handleServiceRequestMenu(Scanner scanner, ManageServices manageServices, ManageCustomer manageCustomer, ManageVehicle manageVehicle, PartManager partManager) {
        System.out.print("Enter customer mobile number: ");
        customerMobileNumber = scanner.nextLine().trim();
        Customer customer = manageCustomer.getCustomer(customerMobileNumber);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter vehicle registration number: ");
        selectedVehicleNumber = scanner.nextLine().trim();
        Vehicle vehicle = manageVehicle.getVehicle(selectedVehicleNumber);
        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }
        newServiceRequest(scanner);
    }

    private void newServiceRequest(Scanner scanner) {
        while (true) {
            System.out.println("\n--- New Service Menu ---");
            System.out.println("1. Maintenance Service");
            System.out.println("2. Repairing Service");
            System.out.println("3. Oil Change Service");
            System.out.println("4. Prepare and Display Bill");
            System.out.println("5. View Today's Business");
            System.out.println("6. View Business by Given Date");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    return;
                case 1:
                    maintenanceService(scanner);
                    break;
                case 2:
                    repairingService(scanner);
                    break;
                case 3:
                    oilChangeService(scanner);
                    break;
                case 4:
                    generateAndDisplayBill();
                    break;
                case 5:
                    viewTodaysBusiness();
                    break;
                case 6:
                    System.out.print("Enter date (YYYY-MM-DD) to view business: ");
                    String date = scanner.nextLine();
                    viewBusinessByDate(date);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void maintenanceService(Scanner scanner) {
        System.out.print("What is done in maintenance: ");
        String maintenanceTask = scanner.nextLine();
        System.out.print("Enter the labour charges: ");
        double laborCharges = scanner.nextDouble();
        scanner.nextLine();
        totalLaborCharges += laborCharges;
        billEntries.add("Vehicle: " + selectedVehicleNumber + ", Service: Maintenance, Labour Charges: " + laborCharges);
    }

    private void repairingService(Scanner scanner) {
        System.out.print("Enter repair description: ");
        String repairDescription = scanner.nextLine();
        System.out.print("Enter the labour charges: ");
        double laborCharges = scanner.nextDouble();
        System.out.print("Enter the oil cost: ");
        double oilCost = scanner.nextDouble();
        scanner.nextLine();
        totalLaborCharges += laborCharges;
        totalOilCost += oilCost;
        billEntries.add("Vehicle: " + selectedVehicleNumber + ", Service: Repairing, Description: " + repairDescription + ", Labour Charges: " + laborCharges + ", Oil Cost: " + oilCost);
    }

    private void oilChangeService(Scanner scanner) {
        System.out.print("Enter the oil cost: ");
        double oilCost = scanner.nextDouble();
        scanner.nextLine();
        totalOilCost += oilCost;
        billEntries.add("Vehicle: " + selectedVehicleNumber + ", Service: Oil Change, Oil Cost: " + oilCost);
    }

    private void generateAndDisplayBill() {
        double totalAmount = totalLaborCharges + totalOilCost;
        double tax = totalAmount * 0.126;
        double finalAmount = totalAmount + tax;

        System.out.println("\n********************************Bill********************************");
        System.out.println("Service Date - " + new Date());
        System.out.println("Customer Name - " + customerMobileNumber);
        System.out.println("Vehicle Number - " + selectedVehicleNumber);
        System.out.println("------------------------------------------------------------");
        for (String entry : billEntries) {
            System.out.println(entry);
        }
        System.out.println("------------------------------------------------------------");
        System.out.println("Total Amount - " + totalAmount);
        System.out.println("Total Tax 12.6% - " + tax);
        System.out.println("Total Bill Amount - " + finalAmount);
        System.out.println("********************************************************************");

        try (FileWriter writer = new FileWriter("bills.txt", true)) {
            writer.write("Date: " + new Date() + "\n");
            writer.write("Customer: " + customerMobileNumber + "\n");
            writer.write("Vehicle: " + selectedVehicleNumber + "\n");
            writer.write("Total Amount: " + totalAmount + "\n");
            writer.write("Tax (12.6%): " + tax + "\n");
            writer.write("Final Amount: " + finalAmount + "\n");
            writer.write("-------------------------------------------------------------\n");
        } catch (IOException e) {
            System.out.println("Error saving bill: " + e.getMessage());
        }

        totalLaborCharges = 0.0;
        totalOilCost = 0.0;
        billEntries.clear();
    }

    public void viewTodaysBusiness() {
        double totalBusiness = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader("bills.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Final Amount:")) {
                    totalBusiness += Double.parseDouble(line.split(": ")[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading business records: " + e.getMessage());
        }
        System.out.println("Total Business for Today: " + totalBusiness);
    }

    public void viewBusinessByDate(String date) {
        double totalBusiness = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader("bills.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Date: " + date)) {
                    while ((line = reader.readLine()) != null && !line.startsWith("Final Amount:")) {
                    }
                    if (line != null && line.startsWith("Final Amount:")) {
                        totalBusiness += Double.parseDouble(line.split(": ")[1]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading business records: " + e.getMessage());
        }
        System.out.println("Total Business for " + date + ": " + totalBusiness);
    }
}
