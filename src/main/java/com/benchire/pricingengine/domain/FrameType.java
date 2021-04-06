
package com.benchire.pricingengine.domain;

/**
 * @author Vikas M Gowda
 *
 */
public enum FrameType {

	CANTILEVER("CANTILEVER"), DIAMOND("DIAMOND"), ORDINARY("ORDINARY"), PRONE("PRONE"),
	RECUMBENT("RECUMBENT"), STEPTHROUGH("STEPTHROUGH");

	private String value;

	private FrameType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static FrameType getKey(String frameType) {
		for (FrameType type : FrameType.values()) {
			if (type.getValue().equals(frameType)) {
				return type;
			}
		}
		return null;
	}
}
