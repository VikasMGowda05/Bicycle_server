package com.benchire.pricingengine.domain;

/**
 * @author Vikas M Gowda
 *
 */
public enum HandleType {

	DROP("DROP"), ORDINARY("ORDINARY"), RANDONNEUR("RANDONNEUR"), STANDARD("STANDARD"), TRACK("TRACK");

	private String value;

	private HandleType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static HandleType getKey(String handleType) {
		for (HandleType type : HandleType.values()) {
			if (type.getValue().equals(handleType)) {
				return type;
			}
		}
		return null;
	}
}
