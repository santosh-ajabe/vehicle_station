package com.menu;

import java.util.*;
import com.customer.*;
import com.parts.*;
import com.services.*;
import com.vehicle.*;

public class Menu {

    public void displayMainMenu() {
        System.out.println("Main Menu");
        System.out.println("0. Exit");
        System.out.println("1. Customer");
        System.out.println("2. Vehicles");
        System.out.println("3. Service Request");
        System.out.println("4. Parts");
        System.out.println("5. Today's Business");
        System.out.println("6. Given Date's Business");
        System.out.print("Enter your choice: ");
    }

    public void displayCustomerMenu() {
        System.out.println("Customer Menu");
        System.out.println("0. Go Back");
        System.out.println("1. Add Customer");
        System.out.println("2. Display All Customers");
        System.out.println("3. Display Customer Details");
        System.out.println("4. Edit Customer");
        System.out.println("5. Delete Customer");
        System.out.print("Enter your choice: ");
    }

    public void displayVehicleMenu() {
        System.out.println("Vehicle Menu");
        System.out.println("0. Go Back");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Display All Vehicles");
        System.out.println("3. Display Customer Vehicles");
        System.out.println("4. Edit Vehicle");
        System.out.println("5. Delete Vehicle");
        System.out.print("Enter your choice: ");
    }

    public void displayServiceRequestMenu() {
        System.out.println("Service Request Menu");
        System.out.println("0. Go Back");
        System.out.println("1. Select Customer Vehicle");
        System.out.println("2. Process Request");
        System.out.println("3. Prepare and Display Bill");
        System.out.println("4. Get Bill Payment from Customer");
        System.out.print("Enter your choice: ");
    }

    public void displayProcessRequestMenu() {
        System.out.println("Process Request Menu");
        System.out.println("0. Go Back");
        System.out.println("1. New Service");
        System.out.println("2. Existing Service");
        System.out.println("3. Maintenance");
        System.out.println("4. Repairing");
        System.out.println("5. Engine Oil Change");
        System.out.print("Enter your choice: ");
    }

    public void displayPartsMenu() {
        System.out.println("Parts Menu");
        System.out.println("0. Go Back");
        System.out.println("1. Add Parts");
        System.out.println("2. Display All Parts");
        System.out.println("3. Edit Part Price");
        System.out.println("4. Delete Part");
        System.out.print("Enter your choice: ");
    }
}
