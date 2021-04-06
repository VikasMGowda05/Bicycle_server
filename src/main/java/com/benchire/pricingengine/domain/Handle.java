package com.benchire.pricingengine.domain;
/**
 * 
 * @author Vikas M Gowda
 *
 */
public class Handle {

	private String type;

	private boolean shockLock;

	private Double price;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isShockLock() {
		return shockLock;
	}

	public void setShockLock(boolean shockLock) {
		this.shockLock = shockLock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Handle [type=%s, shockLock=%s, price=%s]", type, shockLock, price);
	}

	

	
}
