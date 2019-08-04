package com.healthq.core.exception;

/**
 * Exceptions that indicate a core database exception that cannot be handled.
 *
 */
public class HealthQDatabaseException extends HealthQCoreException {
	private static final long serialVersionUID = 1L;

	public HealthQDatabaseException() {
		super();
	}

	public HealthQDatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HealthQDatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public HealthQDatabaseException(String message) {
		super(message);
	}

	public HealthQDatabaseException(Throwable cause) {
		super(cause);
	}
}
