package com.healthq.core.model;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.beans.BeanUtils;

/**
 * @author YingPeng Que
 *
 */
@Data
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class HQPatientRecordsDTO extends HQPeopleRecordsDTO {
	private String medicareNumber;
	
	public HQPatientRecordsDTO(final UUID id, String firstName,
			String lastName, String email, String phone, String medicareNumber) {
		super(id, firstName,
				lastName, email, phone);
		this.medicareNumber = medicareNumber;
	}
	
	public HQPatientRecordsDTO(HQPeopleRecordsDTO hqPeopleRecordsDTO) {
		BeanUtils.copyProperties(hqPeopleRecordsDTO, this);
		//then use the setter for fields additional to the parent DTO.
	}
	
}