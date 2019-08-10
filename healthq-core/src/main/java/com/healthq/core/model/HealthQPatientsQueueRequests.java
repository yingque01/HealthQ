package com.healthq.core.model;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The entity class for CRUD operations from the database table: healthq.patient_queue_requests.
 * @author YingPeng Que
 *
 */
@Data
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class HealthQPatientsQueueRequests extends BaseEntity {
	private String patientsId;
	private String patientQueuesId;
	private Integer positionInQueue;
	private Integer averageWaitingTimeInMinutes;

	/*public HealthQPatientsQueueRequests(final UUID id, final String patientsId,
			final String patientQueuesId, final Integer positionInQueue,
			final Integer averageWaitingTimeInMinutes) {
		super(id);
		this.patientsId = patientsId;
		this.patientQueuesId = patientQueuesId;
		this.positionInQueue = positionInQueue;
		this.averageWaitingTimeInMinutes = averageWaitingTimeInMinutes;
	}*/
}
