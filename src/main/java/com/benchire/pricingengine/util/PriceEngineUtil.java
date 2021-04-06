package com.benchire.pricingengine.util;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.benchire.priceengine.exception.PriceEngineException;
import com.benchire.pricingengine.domain.Bicycle;
import com.benchire.pricingengine.domain.ChainAssembly;
import com.benchire.pricingengine.domain.Frame;
import com.benchire.pricingengine.domain.Handle;
import com.benchire.pricingengine.domain.Rim;
import com.benchire.pricingengine.domain.Seat;
import com.benchire.pricingengine.domain.Wheel;

/**
 * 
 * @author Vikas M Gowda
 *
 *<tt>Utility class which contains method to extract data from JSONArray</tt>
 */
public class PriceEngineUtil {
	
	//specify you file source destination/ directory
	public static String filePath = "/home/spaneos/Documents/Benchire/";
	
	@SuppressWarnings("unchecked")
	public static List<Bicycle> extractingValuesFromJsonArray(JSONArray bicycleList) {
		try {
			List<Bicycle> bicyclelist = new ArrayList<>();
			bicycleList.forEach(bicycle -> {
				// creating Bicycle for each object of JSONArray
				Bicycle bicycleRef = new Bicycle();
				// extracting JSONObject from JSONArray
				JSONObject bicycleObject = (JSONObject) bicycle;
				
				//extracting JSONObject of seat and its value from bicycleObject JSONobject
				JSONObject bicycleObjectSeat = (JSONObject) bicycleObject.get("seat");
				Seat seatRef = new Seat();
				seatRef.setType((String) bicycleObjectSeat.get("type"));

				//extracting JSONObject of Wheel and its value from bicycleObject JSONobject
				JSONObject bicycleObjectWheel = (JSONObject) bicycleObject.get("wheel");

				Wheel wheelRef = new Wheel((String) bicycleObjectWheel.get("spoke"),
						Rim.valueOf((String) bicycleObjectWheel.get("rim")).getValue(),
						(String) bicycleObjectWheel.get("tube"), (String) bicycleObjectWheel.get("tyre"));

				//extracting JSONObject of ChainAssembly and its value from bicycleObject JSONobject
				ChainAssembly chainAssemblyRef = new ChainAssembly();
				JSONObject bicycleObjectChainAssembly = (JSONObject) bicycleObject.get("chainAssembly");
				 Long chainValue = (Long)bicycleObjectChainAssembly.get("chainSize");
				chainAssemblyRef.setChainSize(chainValue.intValue());
				Long speedValue = (Long) bicycleObjectChainAssembly.get("speed");
				chainAssemblyRef.setSpeed(speedValue.intValue());

				//extracting JSONObject of Handle and its value from bicycleObject JSONobject
				Handle handleRef = new Handle();
				JSONObject bicycleObjectHandle = (JSONObject) bicycleObject.get("handle");
				handleRef.setType((String) bicycleObjectHandle.get("type"));
				handleRef.setShockLock((Boolean) bicycleObjectHandle.get("shockLock"));
				
				//extracting JSONObject of frame and its value from bicycleObject JSONobject
				JSONObject bicycleObjectFrame = (JSONObject) bicycleObject.get("frame");
				Frame frameRef = new Frame();
				frameRef.setType((String) bicycleObjectFrame.get("type"));
			
				//setting extracted values to Bicycle
				Long orderValue = (Long) bicycleObject.get("order");
				bicycleRef.setOrder(orderValue.intValue());
				bicycleRef.setDate((String) bicycleObject.get("date"));
				bicycleRef.setChainAssembly(chainAssemblyRef);
				bicycleRef.setFrame(frameRef);
				bicycleRef.setHandle(handleRef);
				bicycleRef.setSeat(seatRef);
				bicycleRef.setWheel(wheelRef);
				bicyclelist.add(bicycleRef);
			});
			
			return bicyclelist;
		} catch (PriceEngineException e) {
			throw new PriceEngineException("Error While reading input from Json Array");
		}
	}
}
