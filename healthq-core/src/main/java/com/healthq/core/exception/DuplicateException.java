package com.healthq.core.exception;

/**
 * Exceptions that indicate duplicate data.  Extended by the Duplicate*
 * exception classes and used by consuming applications to easily detect these
 * sorts of exceptions.
 * 
 * e.g. REST controller can catch DuplicateExceptions of all types and treat them
 * as Conflicts.
 * 
 * @author bknox
 *
 */
public class DuplicateException extends HealthQCoreException {
	private static final long serialVersionUID = 1L;

	public DuplicateException() {
		super();
	}

	public DuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateException(String message) {
		super(message);
	}

	public DuplicateException(Throwable cause) {
		super(cause);
	}
}
