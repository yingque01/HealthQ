package com.healthq.core.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.healthq.core.model.HealthQDoctors;
import com.healthq.core.model.HealthQPatients;
import com.healthq.core.model.HealthQPeopleRecords;

/**
 * This is the CRUD DAO for the rb_rea_publish_events table.
 * 
 * @author YingPeng Que
 *
 */
@Repository
public class HealthQPatientsDao extends HealthQPeopleRecordsDao {
	private static final String HQ_DOCTOR_RECORDS_MEDICARE_NO_COLUMNNAME = "MEDICARE_NO";

	public HealthQPatientsDao() {
		TABLE_NAME = "healthq.patients";
	}

	protected StringBuilder constructCreateHealthQPeopleRecordsSql() {
		StringBuilder createHealthQPeopleRecordsSql = super
				.constructCreateHealthQPeopleRecordsSql();
		createHealthQPeopleRecordsSql.append(" , ")
				.append(HQ_DOCTOR_RECORDS_MEDICARE_NO_COLUMNNAME)
				.append(") VALUES(?,?,?,?,?,?,?,?,?)");
		return createHealthQPeopleRecordsSql;
	}
	
	protected void setPreparedStatement(PreparedStatement ps,
			HealthQPeopleRecords healthQPatients) throws SQLException {
		super.setPreparedStatement(ps, healthQPatients);
		ps.setString(9, ((HealthQPatients)healthQPatients).getMedicareNumber());
	}
	
	protected HealthQPatients doMapRow(ResultSet rs, int rowNum)
			throws SQLException {
		HealthQPatients healthQPatientRecordsDTO = new HealthQPatients(
				super.doMapRow(rs, rowNum));
		healthQPatientRecordsDTO.setMedicareNumber(rs
				.getString(HQ_DOCTOR_RECORDS_MEDICARE_NO_COLUMNNAME));
		return healthQPatientRecordsDTO;
	}
}