package com.benchire.pricingengine.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.json.simple.JSONArray;

import com.benchire.priceengine.exception.PriceEngineException;
import com.benchire.pricingengine.domain.Bicycle;
import com.benchire.pricingengine.util.PriceEngineUtil;

public class PricingEngineServiceImpl {

	/**
	 * <tt>
	 * method to calculate Bicycle price by converting JSONArray to Bicycle Object
	 * </tt>
	 * 
	 * @param bicycleList
	 */
	@SuppressWarnings("unchecked")
	public void calculateBicyclePrice(JSONArray bicycleList) {

		// Instantiating a ThreadPoolExecutor with 10 threads using an Executors factory
		// method as per requirement
		ExecutorService service = Executors.newFixedThreadPool(10);
		try {
			// invoking extractingValuesFromJsonArray() to extract values of JSONArray to
			// Bicycle object
			List<Bicycle> bicycleBuildList = PriceEngineUtil.extractingValuesFromJsonArray(bicycleList);

			// looping over all items of bicycleBuildList
			bicycleBuildList.stream().filter(Objects::nonNull).forEachOrdered(bicycle -> {

				// By using submit(), we are accepting a callable task
				Future<Bicycle> output = service.submit(new PriceCalculator(bicycle));
				try {
					// If the task is complete, it returns the result immediately, otherwise it
					// waits till the task is complete and then returns the result
					Bicycle bicycleOutput = output.get();
					// Add employees to list
					JSONArray bicycleOutputList = new JSONArray();
					bicycleOutputList.add(bicycleOutput);
					String outputFileName = PriceEngineUtil.filePath + "OUTPUT_" + "Bicycle_"
							+ bicycleOutput.getOrder() + ".json";
					try (FileWriter file = new FileWriter(outputFileName)) {
						// we can write any JSONArray or JSONObject instance to the file
						file.write(bicycleOutputList.toJSONString());
						// writes the content of the buffer to the destination and makes the buffer
						// empty for further data to store
						file.flush();

					} catch (PriceEngineException e) {
						throw new PriceEngineException("Error While writing output to JSON file");
					}
				} catch (IOException | InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		service.shutdown();
	}

}
