package com.healthq.core.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.healthq.core.model.HealthQPatients;

/**
 * This is the CRUD DAO for the rb_rea_publish_events table.
 * 
 * @author YingPeng Que
 *
 */
@Repository
public class HealthQPatientsDao extends HealthQPeopleRecordsDao {
	//2689352635
	private static final String HQ_DOCTOR_RECORDS_MEDICARE_NO_COLUMNNAME = "MEDICARE_NO";

	public HealthQPatientsDao() {
		TABLE_NAME = "healthq.patients";
	}

	protected void setPreparedStatement(PreparedStatement ps,
			HealthQPatients healthQPatientRecordsDTO)
			throws SQLException {
		super.setPreparedStatement(ps, healthQPatientRecordsDTO);
		ps.setString(9, healthQPatientRecordsDTO.getMedicareNumber());
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