package com.services;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.services.Services;
@SuppressWarnings("unused")
public class ManageServices {
    private final List<Service> services;

    public ManageServices() {
        this.services = new ArrayList<>();
    }

    public void addService(com.services.Service service) {
        services.addAll((Collection<? extends Service>) service);
    }

    public void displayAllServices() {
        if (services.isEmpty()) {
            System.out.println("No services recorded yet.");
            return;
        }

        System.out.println("\n--- Existing Services ---");
        for (Service service : services) {
            System.out.println(service);
        }
    }

	public double getServiceCostById(String serviceId) {
		return 0;
	}
}
