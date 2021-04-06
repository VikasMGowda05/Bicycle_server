package com.benchire.pricingengine.domain;
/**
 * 
 * @author Vikas M Gowda
 *
 */
public class Bicycle {
	
    private int order;
	
	private String date;

	private Frame frame;

	private Handle handle;

	private Seat seat;

	private Wheel wheel;
	
	private Double price;

	private ChainAssembly chainAssembly;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public Handle getHandle() {
		return handle;
	}

	public void setHandle(Handle handle) {
		this.handle = handle;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ChainAssembly getChainAssembly() {
		return chainAssembly;
	}

	public void setChainAssembly(ChainAssembly chainAssembly) {
		this.chainAssembly = chainAssembly;
	}

	public void calculatePrice() {
		
		price = Double.valueOf(0);
			
			if(this.wheel!=null) {
				price = price + wheel.getPrice();
			}
			if(this.frame!=null) {
				price = price + frame.getPrice();
			}
			if(this.handle!=null) {
				price = price + handle.getPrice();
			}
			if(this.seat!=null) {
				price = price + seat.getPrice();
			}
			if(this.chainAssembly!=null) {
				price = price + chainAssembly.getPrice();
			}
			setPrice(price);
		}

	@Override
	public String toString() {
		return String.format(
				"Bicycle [order=%s, date=%s, frame=%s, handle=%s, seat=%s, wheel=%s, price=%s, chainAssembly=%s]",
				order, date, frame, handle, seat, wheel, price, chainAssembly);
	}
	

	

}
