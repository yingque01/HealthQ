package com.healthq.core.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.healthq.core.exception.HealthQDatabaseException;
import com.healthq.core.model.HealthQPeopleRecords;

/**
 * This is the base CRUD DAO for the database tables storing people records.
 * 
 * @author YingPeng Que
 *
 */
@Repository
@Slf4j
public class HealthQPeopleRecordsDao extends BaseDAO {
	private static final String HQ_PEOPLE_RECORDS_FIRSTNAME_COLUMNNAME = "FIRST_NAME";
	private static final String HQ_PEOPLE_RECORDS_MIDDLENAME_COLUMNNAME = "MIDDLE_NAME";
	private static final String HQ_PEOPLE_RECORDS_LASTNAME_COLUMNNAME = "LAST_NAME";
	private static final String HQ_PEOPLE_RECORDS_GENDER_COLUMNNAME = "GENDER";
	private static final String HQ_PEOPLE_RECORDS_DOB_COLUMNNAME = "DATE_OF_BIRTH";
	private static final String HQ_PEOPLE_RECORDS_PHONE_COLUMNNAME = "PHONE";
	private static final String HQ_PEOPLE_RECORDS_EMAIL_COLUMNNAME = "EMAIL";

	/**
	 * Return the people records by a given record_id (the auto incremented
	 * numeric id). If no transaction can be found, null is returned.
	 * 
	 * @author Yingpeng Que
	 * @return
	 */
	public HealthQPeopleRecords findHealthQPeopleRecordsByRecordId(Long recordId) {
		String findHealthQPeopleRecordstByIdSql = "SELECT * FROM " + TABLE_NAME
				+ " WHERE " + RECORD_ID_COLUMNNAME + " = (?)";
		try {
			HealthQPeopleRecords healthQPeopleRecords = jdbcTemplate
					.queryForObject(findHealthQPeopleRecordstByIdSql,
							new HealthQPeopleRecordsMapper(), recordId);
			log.debug(String
					.format("The healthQPeopleRecords for this recordId %d has the following details %s",
							recordId, healthQPeopleRecords));
			return healthQPeopleRecords;
		} catch (EmptyResultDataAccessException noResultE) {
			// for queryForObject method, Data access exception thrown when a
			// result was expected to have
			// at least one row (or element) but zero rows (or elements) were
			// actually returned.
			log.warn(String
					.format("No healthQPeopleRecords can be found for this recordId %d",
							recordId));
			return null;
		}
	}

	protected StringBuilder constructCreateHealthQPeopleRecordsSql() {
		StringBuilder createHealthQPeopleRecordsSql = new StringBuilder();
		createHealthQPeopleRecordsSql.append("INSERT INTO ").append(TABLE_NAME)
				.append(" (").append(ID_COLUMNNAME).append(", ")
				.append(HQ_PEOPLE_RECORDS_FIRSTNAME_COLUMNNAME).append(", ")
				.append(HQ_PEOPLE_RECORDS_MIDDLENAME_COLUMNNAME).append(", ")
				.append(HQ_PEOPLE_RECORDS_LASTNAME_COLUMNNAME).append(", ")
				.append(HQ_PEOPLE_RECORDS_GENDER_COLUMNNAME).append(", ")
				.append(HQ_PEOPLE_RECORDS_DOB_COLUMNNAME).append(", ")
				.append(HQ_PEOPLE_RECORDS_EMAIL_COLUMNNAME).append(" , ")
				.append(HQ_PEOPLE_RECORDS_PHONE_COLUMNNAME);
		return createHealthQPeopleRecordsSql;
	}

	/**
	 * Return the people records by a given id (the UUID). If no transaction can
	 * be found, null is returned.
	 * 
	 * @author Yingpeng Que
	 * @return
	 */
	public HealthQPeopleRecords findHealthQPeopleRecordsById(UUID id) {
		String findHealthQPeopleRecordsById = "SELECT * FROM " + TABLE_NAME
				+ " WHERE " + ID_COLUMNNAME + " = (?)";
		try {
			HealthQPeopleRecords healthQPeopleRecords = jdbcTemplate
					.queryForObject(findHealthQPeopleRecordsById,
							new HealthQPeopleRecordsMapper(), id.toString());
			log.debug(String
					.format("The rbBasePublishEvents for this id %d has the following details %s",
							id.toString(), healthQPeopleRecords));
			return healthQPeopleRecords;
		} catch (EmptyResultDataAccessException noResultE) {
			// for queryForObject method, Data access exception thrown when a
			// result was expected to have
			// at least one row (or element) but zero rows (or elements) were
			// actually returned.
			log.warn(String.format(
					"No healthQPeopleRecords can be found for this id %d",
					id.toString()));
			return null;
		}
	}

	// batch update and batch inserts are not yet implemented
	// batch update and batch inserts are not yet implemented
	/**
	 * insert a new entry of HealthQPeopleRecords.
	 * 
	 * @param index
	 *            of the HealthQPeopleRecords created in DB.
	 * @return
	 */
	public Long create(HealthQPeopleRecords healthQPeopleRecords) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate
				.update(connection -> {
					PreparedStatement ps = connection
							.prepareStatement(constructCreateHealthQPeopleRecordsSql()
									.toString());
					setPreparedStatement(ps, healthQPeopleRecords);
					return ps;
				}, keyHolder);
		return (Long) keyHolder.getKey();
	}

	/**
	 * This function can be overriden later by the children classes.
	 * 
	 * @param rs
	 * @param rowNum
	 * @return
	 * @throws SQLException
	 */
	protected void setPreparedStatement(PreparedStatement ps,
			HealthQPeopleRecords healthQPeopleRecords) throws SQLException {
		ps.setString(1, healthQPeopleRecords.getId().toString());
		// let isActive default
		ps.setString(2, healthQPeopleRecords.getFirstName());
		ps.setString(3, healthQPeopleRecords.getMiddleName());
		ps.setString(4, healthQPeopleRecords.getLastName());
		ps.setString(5, healthQPeopleRecords.getGender());
		ps.setDate(6, healthQPeopleRecords.getDateOfBirth());
		ps.setString(7, healthQPeopleRecords.getEmail());
		ps.setString(8, healthQPeopleRecords.getPhone());
		// let the createdDateTime and updatedDateTime default
	}

	/**
	 * A class to map a result set of rows into a list of objects. can be used
	 * to return a list of people
	 * 
	 * @author Yingpeng Que
	 *
	 */
	private final class HealthQPeopleRecordsListExtractor implements
			ResultSetExtractor<List<HealthQPeopleRecords>> {
		public List<HealthQPeopleRecords> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			int row = 0;
			List<HealthQPeopleRecords> statuses = new ArrayList<HealthQPeopleRecords>();
			HealthQPeopleRecordsMapper mapper = new HealthQPeopleRecordsMapper();
			while (rs.next()) {
				statuses.add(mapper.mapRow(rs, row++));
			}
			return statuses;
		}
	}

	/**
	 * Pattern here is use an private class to do the mapping from raw jdbc
	 * template result into the object to be used elsewhere.
	 * 
	 * @author Yingpeng Que
	 *
	 */
	private final class HealthQPeopleRecordsMapper implements
			RowMapper<HealthQPeopleRecords> {
		public HealthQPeopleRecords mapRow(ResultSet rs, int rowNum) {
			try {
				return doMapRow(rs, rowNum);
			} catch (SQLException e) {
				throw new HealthQDatabaseException(e);
			}
		}
	}

	/**
	 * This function can be overridden later by the children classes.
	 * 
	 * @param rs
	 * @param rowNum
	 * @return
	 * @throws SQLException
	 */
	protected HealthQPeopleRecords doMapRow(ResultSet rs, int rowNum)
			throws SQLException {
		HealthQPeopleRecords hqPeopleRecords = new HealthQPeopleRecords();
		hqPeopleRecords.setRecordId(rs.getLong(RECORD_ID_COLUMNNAME));
		hqPeopleRecords.setId(UUID.fromString(rs.getString(ID_COLUMNNAME)));
		hqPeopleRecords.setIsActive(BooleanUtils.toBooleanObject(rs
				.getInt(IS_ACTIVE_COLUMNNAME)));
		hqPeopleRecords.setFirstName(rs
				.getString(HQ_PEOPLE_RECORDS_FIRSTNAME_COLUMNNAME));
		hqPeopleRecords.setMiddleName(rs
				.getString(HQ_PEOPLE_RECORDS_MIDDLENAME_COLUMNNAME));
		hqPeopleRecords.setLastName(rs
				.getString(HQ_PEOPLE_RECORDS_LASTNAME_COLUMNNAME));
		hqPeopleRecords.setGender(rs
				.getString(HQ_PEOPLE_RECORDS_GENDER_COLUMNNAME));
		hqPeopleRecords.setDateOfBirth(rs
				.getDate(HQ_PEOPLE_RECORDS_DOB_COLUMNNAME));
		hqPeopleRecords.setPhone(rs
				.getString(HQ_PEOPLE_RECORDS_PHONE_COLUMNNAME));
		hqPeopleRecords.setEmail(rs
				.getString(HQ_PEOPLE_RECORDS_EMAIL_COLUMNNAME));
		return hqPeopleRecords;
	}
}
