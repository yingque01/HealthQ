package com.healthq.core.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.healthq.core.model.HealthQDoctors;
import com.healthq.core.model.HealthQPeopleRecords;

/**
 * This is the base CRUD DAO for the database table:
 * healthq.doctors.
 * 
 * @author YingPeng Que
 *
 */
@Repository
public class HealthQDoctorsDao extends HealthQPeopleRecordsDao {
	private static final String HQ_DOCTORS_PROVIDER_NO_COLUMNNAME = "PROVIDER_NO";

	public HealthQDoctorsDao() {
		TABLE_NAME = "healthq.doctors";
	}

	protected StringBuilder constructCreateHealthQPeopleRecordsSql() {
		StringBuilder createHealthQPeopleRecordsSql = super
				.constructCreateHealthQPeopleRecordsSql();
		createHealthQPeopleRecordsSql.append(" , ")
				.append(HQ_DOCTORS_PROVIDER_NO_COLUMNNAME)
				.append(") VALUES(?,?,?,?,?,?,?,?,?)");
		return createHealthQPeopleRecordsSql;
	}

	protected void setPreparedStatement(PreparedStatement ps,
			HealthQPeopleRecords healthQDoctorRecordsDTO) throws SQLException {
		super.setPreparedStatement(ps, healthQDoctorRecordsDTO);
		ps.setString(9, ((HealthQDoctors)healthQDoctorRecordsDTO).getProviderNumber());
	}

	protected HealthQDoctors doMapRow(ResultSet rs, int rowNum)
			throws SQLException {
		HealthQDoctors healthQDoctorRecordsDTO = new HealthQDoctors(
				super.doMapRow(rs, rowNum));
		healthQDoctorRecordsDTO.setProviderNumber(rs
				.getString(HQ_DOCTORS_PROVIDER_NO_COLUMNNAME));
		return healthQDoctorRecordsDTO;
	}
}
