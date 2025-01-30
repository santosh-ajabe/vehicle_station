package com.parts;

import java.io.Serializable;

public class Part implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String partId;
	private String partName;
	private double price;

	public Part(String partId, String partName, double price) {
		this.partId = partId;
		this.partName = partName;
		this.price = price;
	}

	
	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public double getPrice() {
		return price;
	}
	

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Parts{partId='" + partId + '\'' + ", partName='" + partName + '\'' + ", price=" + price + '}';
	}
}
