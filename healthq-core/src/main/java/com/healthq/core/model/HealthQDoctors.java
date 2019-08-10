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
 * healthq.doctors.
 * 
 * @author YingPeng Que
 *
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class HealthQDoctors extends HealthQPeopleRecords {
	private String providerNumber;

	public HealthQDoctors(final UUID id, final String firstName,
			final String middleName, final String lastName,
			final Date dateOfBirth, final String gender, final String email,
			final String phone, final String providerNumber) {
		super(id, firstName, middleName, lastName, dateOfBirth, gender, email,
				phone);
		this.providerNumber = providerNumber;
	}

	public HealthQDoctors(HealthQPeopleRecords hqPeopleRecordsDTO) {
		BeanUtils.copyProperties(hqPeopleRecordsDTO, this);
		// then use the setter for fields additional to the parent entity.
		// e.g, .setProviderNumber
	}

}
