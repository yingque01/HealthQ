package com.healthq.core.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	protected String TABLE_NAME;
	protected static final String RECORD_ID_COLUMNNAME = "RECORD_ID";
	protected static final String ID_COLUMNNAME = "ID";
	protected static final String IS_ACTIVE_COLUMNNAME = "IS_ACTIVE";
	protected static final String CREATED_DATE_TIME_COLUMNNAME = "CREATED_DATE_TIME";
	protected static final String UPDATED_DATE_TIME_COLUMNNAME = "UPDATED_DATE_TIME";
}
