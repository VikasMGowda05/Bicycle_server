package com.benchire.pricingengine.domain;

/**
 * @author Vikas M Gowda
 *
 */

public enum Tube {

	TUBE("TUBE"), TUBELESS("TUBELESS");
	
	private String value;

	private Tube(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Tube getKey(String tube) {
		for (Tube type : Tube.values()) {
			if (type.getValue().equals(tube)) {
				return type;
			}
		}
		return null;
	}
}
