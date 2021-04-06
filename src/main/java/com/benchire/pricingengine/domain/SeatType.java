package com.benchire.pricingengine.domain;

/**
 * @author Vikas M Gowda
 *
 */
public enum SeatType {

	COMFORT("COMFORT"), ORDINARY("ORDINARY"), RACING("RACING");

	private String value;

	private SeatType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static SeatType getKey(String seatType) {
		for (SeatType type : SeatType.values()) {
			if (type.getValue().equals(seatType)) {
				return type;
			}
		}
		return null;
	}

}
