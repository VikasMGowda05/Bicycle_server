package com.benchire.pricingengine.domain;

/**
 * @author Vikas M Gowda
 *
 */
public enum Rim {
	
	STEEL("STEEL"), ALLOY("ALLOY"), CHROME("CHROME");
	
	private String value;

	private Rim(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Rim getKey(String rimType) {
		for (Rim type : Rim.values()) {
			if (type.getValue().equals(rimType)) {
				return type;
			}
		}
		return null;
	}

}
