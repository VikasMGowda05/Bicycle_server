package com.benchire.pricingengine.service;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import com.benchire.pricingengine.domain.Bicycle;
//import com.benchire.priceengine.model.Bicycle;
//import com.benchire.pricingengine.service.ChainAssemblyService;
//import com.benchire.pricingengine.service.FrameService;
//import com.benchire.pricingengine.service.HandleService;
//import com.benchire.pricingengine.service.SeatService;
//import com.benchire.pricingengine.service.WheelService;

/**
 * @author Vikas M Gowda
 * 
 * <tt>class to calculate Bicycle Price by summing up all individual price of parts</tt>
 *
 */
public class PriceCalculator implements Callable<Bicycle> {

	Bicycle bicycle;

	public PriceCalculator(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Bicycle call() throws Exception {
		
		String date = bicycle.getDate();
		Long epochDate = getEpochTime(date);

		WheelServiceImpl wheelService = new WheelServiceImpl(epochDate, bicycle.getWheel());
		wheelService.calculatePrice();

		FrameServiceImpl frameService = new FrameServiceImpl(epochDate, bicycle.getFrame());
		frameService.calculatePrice();

		HandleServiceImpl handleService = new HandleServiceImpl(epochDate, bicycle.getHandle());
		handleService.calculatePrice();

		ChainAssemblyServiceImpl chainAssemblyService = new ChainAssemblyServiceImpl(epochDate, bicycle.getChainAssembly());
		chainAssemblyService.calculatePrice();

		SeatServiceImpl seatService = new SeatServiceImpl(epochDate, bicycle.getSeat());
		seatService.calculatePrice();

		bicycle.calculatePrice();
		
		return bicycle;
	}

	private Long getEpochTime(String dateInString) {
		Long epochTime = Long.valueOf(0);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date inputDate = formatter.parse(dateInString);
			epochTime = inputDate.getTime() / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return epochTime;
	}

}
