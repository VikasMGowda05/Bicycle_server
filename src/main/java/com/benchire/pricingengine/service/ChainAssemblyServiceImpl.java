package com.benchire.pricingengine.service;

import com.benchire.pricingengine.domain.ChainAssembly;
import com.benchire.pricingengine.dto.ChainAssemblyDto;
/**
 * 
 * @author Vikas M Gowda
 * <tt> Service class to calculate price of Chain Assembly</tt>
 *
 */
public class ChainAssemblyServiceImpl {
	private Long date = null;

	private ChainAssembly chainAssembly = null;

	private ChainAssemblyDto chainAssemblyDto = null;

	public ChainAssemblyServiceImpl(Long date, ChainAssembly chainAssembly) {
		this.date = date;
		this.chainAssembly = chainAssembly;
		chainAssemblyDto = new ChainAssemblyDto();
	}

	public double getPrice() {
		return chainAssembly.getPrice();
	}

	public void calculatePrice() {
		double sizePrice = chainAssemblyDto.getChainSizePrice(chainAssembly.getChainSize(), date);

		double speedPrice = chainAssemblyDto.getChainSpeedPrice(chainAssembly.getSpeed(), date);
		double totalPrice = sizePrice + speedPrice;
		chainAssembly.setPrice(totalPrice);
	}
}
