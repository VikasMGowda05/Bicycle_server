package com.benchire.priceengine.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Vikas M Gowda
 *
 */
public class PriceEngineException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(PriceEngineException.class);

	private final String message;

	public PriceEngineException() {
		this.message = "Committee exception occured";
		LOGGER.error(message, this);
	}

	public PriceEngineException(String message, Throwable cause) {
		super();
		this.message = message;
		LOGGER.error(message, cause);
	}

	public PriceEngineException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
