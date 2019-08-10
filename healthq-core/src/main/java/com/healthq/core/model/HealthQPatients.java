package com.healthq.core.model;

import java.sql.Date;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.beans.BeanUtils;

/**
 * The entity class for CRUD operations from the database table:
 * healthq.patients.
 * 
 * @author YingPeng Que
 *
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class HealthQPatients extends HealthQPeopleRecords {
	//2683952653
	private String medicareNumber;

	public HealthQPatients(final UUID id, final String firstName,
			final String middleName, final String lastName,
			final Date dateOfBirth, final String gender, final String email,
			final String phone, final String medicareNumber) {
		super(id, firstName, middleName, lastName, dateOfBirth, gender, email,
				phone);
		this.medicareNumber = medicareNumber;
	}

	public HealthQPatients(final HealthQPeopleRecords hqPeopleRecordsDTO) {
		BeanUtils.copyProperties(hqPeopleRecordsDTO, this);
		// then use the setter for fields additional to the parent entity.
		// e.g, .setMedicareNumber
	}

}