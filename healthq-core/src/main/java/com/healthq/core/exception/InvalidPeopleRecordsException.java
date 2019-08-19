package com.healthq.core.exception;

public class InvalidPeopleRecordsException extends InvalidException {
	private static final long serialVersionUID = 1L;

	public InvalidPeopleRecordsException() {
		super();
	}

	public InvalidPeopleRecordsException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPeopleRecordsException(String message) {
		super(message);
	}

	public InvalidPeopleRecordsException(Throwable cause) {
		super(cause);
	}
}
