package com.healthq.core.model;

import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Base entity class for CRUD operations from the database.
 * @author YingPeng Que
 *
 */
@Data
@NoArgsConstructor
public class BaseEntity {
	protected Long recordId;
	protected UUID id;
	protected Boolean isActive; //defaults to true
    protected ZonedDateTime createdDateTime; //defaults to current time stamp
	protected ZonedDateTime updatedDateTime; //defaults to null
	
	public BaseEntity(final UUID id) {
		this.id = id;
	}
}
