package com.healthq.core.model;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The entity class for CRUD operations from the database table: healthq.clinic_rooms.
 * @author YingPeng Que
 *
 */
@Data
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class HealthQClinicRooms extends BaseEntity {
	private String clinicsId;
	private String description;

	/*public HealthQClinicRooms(final UUID id, final String clinicsId,
			String description) {
		super(id);
		this.clinicsId = clinicsId;
		this.description = description;
	}*/
}
