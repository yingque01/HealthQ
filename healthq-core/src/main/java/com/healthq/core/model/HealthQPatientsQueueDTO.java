package com.healthq.core.model;

import java.time.ZonedDateTime;
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
public class HealthQPatientsQueueDTO extends BaseDTO {
	private String clinicsId;
	private String clinicRoomsId;
	private String doctorsId;
	private ZonedDateTime startedAt;
	private ZonedDateTime endedAt;
	
	public HealthQPatientsQueueDTO(final UUID id, String clinicRoomsId,
			String doctorsId, final ZonedDateTime startedAt, final ZonedDateTime endedAt) {
		super(id);
		this.clinicRoomsId = clinicRoomsId;
		this.doctorsId = doctorsId;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
	}
}
