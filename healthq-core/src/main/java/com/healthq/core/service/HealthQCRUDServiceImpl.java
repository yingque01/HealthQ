package com.healthq.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.healthq.core.exception.InvalidPeopleRecordsException;
import com.healthq.core.exception.MissingPeopleRecordsException;
import com.healthq.core.model.HealthQPatients;
import com.healthq.core.persistence.HealthQPatientsDao;

@Service
public class HealthQCRUDServiceImpl implements HealthQCRUDService {
	@Autowired
	HealthQPatientsDao healthQPatientsDao;

	@Override
	public HealthQPatients createAPatient(HealthQPatients newPatient) throws InvalidPeopleRecordsException , MissingPeopleRecordsException {
		HealthQPatients healthQPatientCreated = null;
		try {
			Long pkIndex = healthQPatientsDao.create(newPatient);
			healthQPatientCreated = (HealthQPatients) healthQPatientsDao
					.findHealthQPeopleRecordsByRecordId(pkIndex);			
		} catch (DataAccessException dataAccessException) {
			throw new InvalidPeopleRecordsException(
					"Failed to create then retrieve the newPatient: "
							+ newPatient, dataAccessException);
		}
		if (healthQPatientCreated == null)
			throw new MissingPeopleRecordsException(
					"This newPatient: "
							+ newPatient
							+ " was created in the database but cannot be found by its record id");
		return healthQPatientCreated;
	}

}
