package com.healthq.core.persistence;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.healthq.core.config.HealthQCoreAutoConfiguration;
import com.healthq.core.model.HealthQDoctors;

//SpringRunner is an aliase of SpringJUnit4ClassRunner for JUnit 4.12 or above.
//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HealthQCoreAutoConfiguration.class)
@TestPropertySource(locations = "classpath:application-test.properties")
// Do not need this as we specify what our config and context is
// @SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class HealthQDoctorsDaoTest extends TestWithEmbeddedDBBase {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	@Autowired
	HealthQDoctorsDao healthQDoctorsDao;

	/**
	 * Just to test the in memory DB set up.
	 */
	@Test
	public void testSelectOneFromDual() {
		jdbcTemplate.execute("select 1 from dual");
		Integer resultOf1 = jdbcTemplate.queryForObject("SELECT 1 from dual",
				null, Integer.class);
		assertEquals(Integer.valueOf(1), resultOf1);
		log.info("select 1 returned 1!");
	}
	
	@Test
	public void testNOtFindingHealthQDoctorByRecordId() {
		healthQDoctorsDao.findHealthQPeopleRecordsByRecordId(1L);
	}

	@Test
	public void testFindingHealthQDoctorAfterCreation() {
		HealthQDoctors healthQDoctorToBeCreated = new HealthQDoctors(
				UUID.randomUUID(), "Vasudha", null, "Sridharan",
				Date.valueOf("2010-01-31"), "Female",
				"yingque210981@gmail.com", "0412023876", "4773976Y");
		Long pkIndex = healthQDoctorsDao.create(healthQDoctorToBeCreated);
		HealthQDoctors healthQDoctorCreated = (HealthQDoctors) healthQDoctorsDao
				.findHealthQPeopleRecordsByRecordId(pkIndex);
		log.info("healthQDoctorCreated :" + healthQDoctorCreated);
	}

}
