package com.benchire.pricingengine.domain;

/**
 * @author Vikas M Gowda
 *
 */
public enum Spoke {

	TANGENTIALLACING("TANGENTIALLACING"), WHEELBUILDING("WHEELBUILDING");

	private String value;

	private Spoke(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Spoke getKey(String spoke) {
		for (Spoke type : Spoke.values()) {
			if (type.getValue().equals(spoke)) {
				return type;
			}
		}
		return null;
	}

}
