package com.healthq.core.service;

import com.healthq.core.exception.InvalidPeopleRecordsException;
import com.healthq.core.exception.MissingPeopleRecordsException;
import com.healthq.core.model.HealthQPatients;

/**
 * This is the interface defining the core service logic functions for the HealthQ project.
 * @author YingPeng Que
 *
 */
public interface HealthQCRUDService {

	public HealthQPatients createAPatient(HealthQPatients newPatient)
			throws InvalidPeopleRecordsException, MissingPeopleRecordsException;
}
