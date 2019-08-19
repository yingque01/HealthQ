package com.healthq.core.exception;

/**
 * Exceptions that indicate missing/not found entities/data.  Extended by the Missing*
 * exception classes and used by consuming applications to easily detect these
 * sorts of exceptions.
 * 
 * e.g. REST controller can catch MissingExceptions of all types and treat them
 * as Not Found.
 * 
 * @author bknox
 *
 */
public class MissingException extends HealthQCoreException {
	private static final long serialVersionUID = 1L;

	public MissingException() {
		super();
	}

	public MissingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MissingException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissingException(String message) {
		super(message);
	}

	public MissingException(Throwable cause) {
		super(cause);
	}
}
