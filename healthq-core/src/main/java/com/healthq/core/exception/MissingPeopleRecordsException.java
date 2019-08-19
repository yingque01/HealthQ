package com.healthq.core.exception;

public class MissingPeopleRecordsException extends MissingException {
	private static final long serialVersionUID = 1L;

	public MissingPeopleRecordsException() {
		super();
	}

	public MissingPeopleRecordsException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissingPeopleRecordsException(String message) {
		super(message);
	}

	public MissingPeopleRecordsException(Throwable cause) {
		super(cause);
	}
}
