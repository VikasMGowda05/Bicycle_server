package com.benchire.pricingengine;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PricingEngineApplicationTests {

	@Test
	void contextLoads() throws ParseException {
		try {
			System.out.println("starting test cases");
			 String [] args = { "one", "two", "three" };
			 PricingEngineApplication.main(args);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
