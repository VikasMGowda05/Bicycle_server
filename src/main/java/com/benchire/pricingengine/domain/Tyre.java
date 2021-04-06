package com.benchire.pricingengine.domain;

/**
 * @author Vikas M Gowda
 *
 */
public enum Tyre {

	CLINCHER("CLINCHER"), TUBULAR("TUBULAR");
	private String value;

	private Tyre(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Tyre getKey(String tyre) {
		for (Tyre type : Tyre.values()) {
			if (type.getValue().equals(tyre)) {
				return type;
			}
		}
		return null;
	}
	
}
