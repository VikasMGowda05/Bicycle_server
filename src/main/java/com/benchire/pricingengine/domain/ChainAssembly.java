package com.benchire.pricingengine.domain;

/**
 * 
 * @author Vikas M Gowda
 *
 */
public class ChainAssembly {
	private int chainSize;

	private int speed;

	private Double price;

	public int getChainSize() {
		return chainSize;
	}

	public void setChainSize(int chainSize) {
		this.chainSize = chainSize;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("ChainAssembly [chainSize=%s, speed=%s, price=%s]", chainSize, speed, price);
	}



}
