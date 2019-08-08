package com.healthq.core.model;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author YingPeng Que
 *
 */
@Data
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class HQPatientsQueueRequestsDTO extends BaseDTO {
	private String patientsId;
	private String patientQueuesId;
	private Integer positionInQueue;
	private Integer averageWaitingTimeInMinutes;

	public HQPatientsQueueRequestsDTO(final UUID id, final String patientsId,
			final String patientQueuesId, final Integer positionInQueue,
			final Integer averageWaitingTimeInMinutes) {
		super(id);
		this.patientsId = patientsId;
		this.patientQueuesId = patientQueuesId;
		this.positionInQueue = positionInQueue;
		this.averageWaitingTimeInMinutes = averageWaitingTimeInMinutes;
	}
}
