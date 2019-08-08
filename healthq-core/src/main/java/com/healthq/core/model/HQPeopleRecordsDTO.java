package com.healthq.core.model;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class HQPeopleRecordsDTO extends BaseDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public HQPeopleRecordsDTO(final UUID id, String firstName,
			String lastName, String email, String phone) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}
}

