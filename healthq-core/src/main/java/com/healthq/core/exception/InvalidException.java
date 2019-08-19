package com.healthq.core.exception;

import com.healthq.core.exception.HealthQCoreException;

/**
 * Exceptions that indicate invalid data/operations.  Extended by the Invalid*
 * exception classes and used by consuming applications to easily detect these
 * sorts of exceptions.
 * 
 * e.g. REST controller can catch InvalidExceptions of all types and treat them
 * as Bad Requests.
 * 
 * @author bknox
 *
 */
public class InvalidException extends HealthQCoreException {
	private static final long serialVersionUID = 1L;

	public InvalidException() {
		super();
	}

	public InvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidException(String message) {
		super(message);
	}

	public InvalidException(Throwable cause) {
		super(cause);
	}
}
