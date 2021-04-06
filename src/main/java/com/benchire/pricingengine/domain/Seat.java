package com.benchire.pricingengine.domain;
/**
 * 
 * @author Vikas M Gowda
 *
 */
public class Seat {
	private String type;

	private Double price;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return String.format("Seat [type=%s, price=%s]", type, price);
	}

	
	
	
}
