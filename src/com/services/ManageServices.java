package com.services;

import java.util.*;

import com.customer.Customer;
import com.parts.*;
import com.vehicle.Vehicle;

public class ManageServices {
    private LinkedList<Services> serviceRequests;

    public ManageServices() {
        serviceRequests = new LinkedList<>();
    }

    public void addService(Services service) {
        serviceRequests.add(service);
    }

    public void displayAllServices() {
        if (serviceRequests.isEmpty()) {
            System.out.println("No services available.");
        } else {
            serviceRequests.forEach(System.out::println);
        }
    }

	public void addService(Customer customer, Vehicle vehicle, String serviceType, double charges) {
		
		
	}

	public void displayServicesByCustomer(String searchMobile) {
	
	}
}
