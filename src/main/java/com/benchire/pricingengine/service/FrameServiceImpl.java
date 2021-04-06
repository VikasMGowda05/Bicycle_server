package com.benchire.pricingengine.service;

import com.benchire.pricingengine.domain.Frame;
import com.benchire.pricingengine.dto.FrameDto;
/**
 * 
 * @author Vikas M Gowda
 * 
 *         <tt> class implementation to calculate individual parts price of Frame based on requirements</tt>
 *
 */
public class FrameServiceImpl {
	
	private Long date = null;

	private Frame frame = null;

	private FrameDto frameDto = null;

	public FrameServiceImpl(Long date, Frame wheel) {
		this.date = date;
		this.frame = wheel;
		frameDto = new FrameDto();
	}

	public double getPrice() {
		return frame.getPrice();
	}

	public void calculatePrice() {
		double spokePrice = frameDto.getFramePrice(frame.getType(), date);
		double totalPrice = spokePrice;
		frame.setPrice(totalPrice);
	}

}
