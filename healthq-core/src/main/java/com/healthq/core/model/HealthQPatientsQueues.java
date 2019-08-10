package com.healthq.core.model;

import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The entity class for CRUD operations from the database table: healthq.patient_queues.
 * @author YingPeng Que
 *
 */
@Data
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class HealthQPatientsQueues extends BaseEntity {
	private String clinicsId;
	private String clinicRoomsId;
	private String doctorsId;
	private ZonedDateTime startedAt;
	private ZonedDateTime endedAt;
	
	/*public HealthQPatientsQueues(final UUID id, String clinicRoomsId,
			String doctorsId, final ZonedDateTime startedAt, final ZonedDateTime endedAt) {
		super(id);
		this.clinicRoomsId = clinicRoomsId;
		this.doctorsId = doctorsId;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
	}*/
}
