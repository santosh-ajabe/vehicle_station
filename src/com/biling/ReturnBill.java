package com.biling;
import com.biling.Bill;
import com.services.ManageServices;
import com.customer.Customer;
import com.customer.ManageCustomer;
import com.vehicle.ManageVehicle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReturnBill {

    private List<Bill> billRecords = new ArrayList<>();

    public  void  createBill(Scanner scanner, ManageCustomer manageCustomer, ManageVehicle manageVehicle, ManageServices manageServices) {
        System.out.println("\n--- Create Bill ---");
        
        
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        Customer customerName = manageCustomer.getCustomer(customerId);
        if (customerName == null) {
            System.out.println("Customer not found!");
            
        }
        
        
        System.out.print("Enter Vehicle ID: ");
        String vehicleId = scanner.nextLine();
        String vehicleDetails = manageVehicle.getVehicleDetailsById(vehicleId);
        if (vehicleDetails == null) {
            System.out.println("Vehicle not found!");
           
        }

     
        System.out.println("Available Services:");
        manageServices.displayAllServices();
        System.out.print("Enter Service ID: ");
        String serviceId = scanner.nextLine();
        double serviceCost = manageServices.getServiceCostById(serviceId);
        if (serviceCost <= 0) {
            System.out.println("Invalid Service ID!");
           
        }

       
        Bill bill = new Bill();
        bill.setCustomerId(customerId);
        bill.setCustomerName(customerName);
        bill.setVehicleId(vehicleId);
        bill.setVehicleDetails(vehicleDetails);
        bill.setServiceId(serviceId);
        bill.setServiceCost(serviceCost);
        bill.setBillDate(new Date());

        
         billRecords.add(bill);
        System.out.println("Bill created successfully!");
        System.out.println(bill);
    }

    public void viewAllBills() {
        if (billRecords.isEmpty()) {
            System.out.println("No bills available.");
            return;
        }

        System.out.println("\n--- All Bills ---");
        for (Bill bill : billRecords) {
            System.out.println(bill);
        }
    }

    public void viewTodaysBusiness() {
        double totalBusiness = 0;
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("\n--- Today's Business ---");
        for (Bill bill : billRecords) {
            if (sdf.format(bill.getBillDate()).equals(sdf.format(today))) {
                System.out.println(bill);
                totalBusiness += bill.getServiceCost();
            }
        }

        System.out.println("Total Business for Today: $" + totalBusiness);
    }

    public void viewBusinessByDate(Scanner scanner) {
        System.out.print("Enter Date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();
        double totalBusiness = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("\n--- Business on " + inputDate + " ---");
        for (Bill bill : billRecords) {
            if (sdf.format(bill.getBillDate()).equals(inputDate)) {
                System.out.println(bill);
                totalBusiness += bill.getServiceCost();
            }
        }

        System.out.println("Total Business for " + inputDate + ": $" + totalBusiness);
    }

	public void viewReturnBillDetails(ReturnBill b1) {
		
	
	}
}
