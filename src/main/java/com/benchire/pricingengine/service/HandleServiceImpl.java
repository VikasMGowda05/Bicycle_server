package com.benchire.pricingengine.service;

import com.benchire.pricingengine.domain.Handle;
import com.benchire.pricingengine.dto.HandleDto;
/**
 * 
 * @author Vikas M Gowda
 * 
 *         <tt> class implementation to calculate individual parts price of Handle based on requirements</tt>
 *
 */
public class HandleServiceImpl {

	private Long date = null;

	private Handle handle = null;

	private HandleDto handleDto = null;

	public HandleServiceImpl(Long date, Handle handle) {
		this.date = date;
		this.handle = handle;
		handleDto = new HandleDto();
	}

	public double getPrice() {
		return handle.getPrice();
	}

	public void calculatePrice() {
		double spokePrice = handleDto.getHandlePrice(handle.getType(), date);       
		double shockLockPrice = handleDto.getShocklockPrice(handle.isShockLock(), date);
		double totalPrice = spokePrice + shockLockPrice;
		handle.setPrice(totalPrice);
	}

	
}
