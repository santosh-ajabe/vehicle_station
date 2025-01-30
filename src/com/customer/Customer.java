package com.customer;

import java.io.*;
import java.util.*;
import com.vehicle.Vehicle;

public class Customer implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String address;
    private String mobileNumber;
    private HashMap<String, Vehicle> vehicles;

    public Customer() {
		super();
		 
	}

	public Customer(String name, String address, String mobileNumber) {
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.vehicles = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public HashMap<String, Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleNumber(), vehicle);
    }
    public Vehicle getVehicle(String vno) {
        return vehicles.get(vno);
    }
    public void removeVehicle(String vehicleNumber) {
        vehicles.remove(vehicleNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return Objects.equals(mobileNumber, customer.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobileNumber);
    }

	@Override
	public String toString() {
		return "Customer{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", mobileNumber='" + mobileNumber
				+ '\'' + ", vehicles=" + vehicles.values() + '}';
	}
}
