package com.services;

public class Service {
    private final String type;
    private final String customerMobile;
    private final String vehicleNumber;
    private final String status;

    public Service(String type, String customerMobile, String vehicleNumber, String status) {
        this.type = type;
        this.customerMobile = customerMobile;
        this.vehicleNumber = vehicleNumber;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Service Type: " + type + ", Customer Mobile: " + customerMobile + 
               ", Vehicle Number: " + vehicleNumber + ", Status: " + status;
    }

	public char[] getServiceDetails() {
	
		return null;
		
	}
}
