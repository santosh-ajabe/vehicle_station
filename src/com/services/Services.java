package com.services;

import java.io.Serializable;
import java.util.*;
import com.parts.*;

public class Services implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceId;
	private String description;
	private List<Part> replacedParts;
	private double laborCharges;

	public Services(String serviceId, String description, double laborCharges) {
		this.serviceId = serviceId;
		this.description = description;
		this.laborCharges = laborCharges;
		this.replacedParts = new LinkedList<>();
	}

	public void addReplacedPart(Part part) {
		replacedParts.add(part);
	}

	public double calculateTotal() {
		double total = laborCharges;
		for (Part part : replacedParts) {
			total += part.getPrice();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Services{serviceId='" + serviceId + '\'' + ", description='" + description + '\'' + ", replacedParts="
				+ replacedParts + ", laborCharges=" + laborCharges + '}';
	}
}