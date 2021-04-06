package com.benchire.pricingengine;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.benchire.pricingengine.service.PricingEngineServiceImpl;
import com.benchire.pricingengine.util.PriceEngineUtil;

/**
 * 
 * @author Vikas M Gowda
 *
 */
@SpringBootApplication
public class PricingEngineApplication {

	/*
	 * main() method where Application starts executing
	 */
	public static void main(String[] args) throws ParseException {
		String inputFilepath = PriceEngineUtil.filePath + "bicycle.json";
		SpringApplication.run(PricingEngineApplication.class, args);
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader(inputFilepath)) {
			// Reading JSON file
			Object bicycleObj = jsonParser.parse(reader);
			// casting to JSONArray
			JSONArray bicycleList = (JSONArray) bicycleObj;

			// Instantiating PricingEngineServiceImpl
			PricingEngineServiceImpl pricingEngineService = new PricingEngineServiceImpl();

			// Invoking calculateBicyclePrice to calculate the individual Bicycle price.
			pricingEngineService.calculateBicyclePrice(bicycleList);
			System.out.println("please check in the desination folder for output");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
