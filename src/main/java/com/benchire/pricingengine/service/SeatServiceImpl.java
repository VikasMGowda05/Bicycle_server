package com.benchire.pricingengine.service;

import com.benchire.pricingengine.domain.Seat;
import com.benchire.pricingengine.dto.SeatDto;
/**
 * 
 * @author Vikas M Gowda
 * 
 *         <tt> class implementation to calculate individual parts price of Seat based on requirements</tt>
 *
 */
public class SeatServiceImpl {
	private Long date = null;

	private Seat seat = null;

	private SeatDto seatDto = null;

	public SeatServiceImpl(Long date, Seat seat) {
		this.date = date;
		this.seat = seat;
		seatDto = new SeatDto();
	}

	public double getPrice() {
		return seat.getPrice();
	}

	public void calculatePrice() {
		double price = seatDto.getSeatPrice(seat.getType(), date);
		double totalPrice = price;
		seat.setPrice(totalPrice);
	}

}
