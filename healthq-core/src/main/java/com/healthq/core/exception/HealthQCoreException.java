package com.healthq.core.exception;

public class HealthQCoreException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public HealthQCoreException() {
	}

	public HealthQCoreException(String message) {
		super(message);
	}

	public HealthQCoreException(Throwable cause) {
		super(cause);
	}

	public HealthQCoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public HealthQCoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
