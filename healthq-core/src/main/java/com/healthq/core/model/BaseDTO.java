package com.healthq.core.model;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseDTO {
	protected Long recordId;
	protected UUID id;

	public BaseDTO(UUID id)
	{
		this.id  = id;
	}
}
