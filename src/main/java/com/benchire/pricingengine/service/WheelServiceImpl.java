package com.benchire.pricingengine.service;

import com.benchire.pricingengine.domain.Wheel;
import com.benchire.pricingengine.dto.WheelDto;

/**
 * 
 * @author Vikas M Gowda
 * 
 *         <tt> class implementation to calculate individual parts price of Wheel based on requirements</tt>
 *
 */
public class WheelServiceImpl {

	private Long date = null;

	private Wheel wheel = null;

	private WheelDto wheelDto = null;

	public WheelServiceImpl(Long date, Wheel wheel) {
		this.date = date;
		this.wheel = wheel;
		wheelDto = new WheelDto();
	}

	public double getPrice() {
		return wheel.getPrice();
	}

	public void calculatePrice() {

		double spokePrice = wheelDto.getSpokePrice(wheel.getSpoke(), date);

		double rimPrice = wheelDto.getRimPrice(wheel.getRim(), date);

		double tubePrice = wheelDto.getTubePrice(wheel.getRim(), date);

		double tyrePrice = wheelDto.getTyrePrice(wheel.getRim(), date);

		double totalPrice = spokePrice + rimPrice + tubePrice + tyrePrice;

		wheel.setPrice(totalPrice);

	}

}
