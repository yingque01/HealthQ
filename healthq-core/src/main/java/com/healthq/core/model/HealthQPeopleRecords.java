package com.healthq.core.model;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The parent entity class for CRUD operations from the database tables storing people records.
 * @author YingPeng Que
 *
 */
@Data
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class HealthQPeopleRecords extends BaseEntity {
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String gender;
	//Use java.sql.date as we are only interested in the YY MM DD with no time information for a DOB.
	protected Date dateOfBirth;
	protected String email;
	protected String phone;
	
	public HealthQPeopleRecords(final UUID id, final String firstName,
			final String middleName, final String lastName,
			final Date dateOfBirth, final String gender, final String email,
			final String phone) {
		super(id);
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phone = phone;
	}
}

