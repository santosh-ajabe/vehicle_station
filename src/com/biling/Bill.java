package com.biling;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.customer.Customer;

public class Bill {

    private String customerId;
    private String customerName;
    private String vehicleId;
    private String vehicleDetails;
    private String serviceId;
    private double serviceCost;
    private Date billDate;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName2) {
        this.customerName = customerName2;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "Bill{" + "CustomerId='" + customerId + '\'' + ", CustomerName='" + customerName + '\'' + ", VehicleId='"
				+ vehicleId + '\'' + ", VehicleDetails='" + vehicleDetails + '\'' + ", ServiceId='" + serviceId + '\''
				+ ", ServiceCost=" + serviceCost + ", BillDate=" + sdf.format(billDate) + '}';
	}

	public void setCustomerName(Customer customerName2) {
		customerName2.getName();
		
	}
}
