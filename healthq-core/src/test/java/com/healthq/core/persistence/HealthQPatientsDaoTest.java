package com.healthq.core.persistence;

import java.sql.Date;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.healthq.core.config.HealthQCoreAutoConfiguration;
import com.healthq.core.model.HealthQPatients;

//SpringRunner is an aliase of SpringJUnit4ClassRunner for JUnit 4.12 or above.
//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HealthQCoreAutoConfiguration.class)
@TestPropertySource(locations = "classpath:application-test.properties")
//Do not need this as we specify what our config and context is
//@SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class HealthQPatientsDaoTest extends TestWithEmbeddedDBBase {
	
	@Autowired
	HealthQPatientsDao healthQPatientsDao;
	
	@Test
	public void testFindingHealthQPatientAfterCreation() {
		HealthQPatients healthQPatientToBeCreated = new HealthQPatients(
				UUID.randomUUID(), "John", null, "Smith",
				Date.valueOf("1993-01-31"), "Male",
				"yingque210981@gmail.com", "0412023876", "2683952653");
		Long pkIndex = healthQPatientsDao.create(healthQPatientToBeCreated);
		HealthQPatients healthQPatientCreated = (HealthQPatients) healthQPatientsDao
				.findHealthQPeopleRecordsByRecordId(pkIndex);
		log.info("healthQPatientToBeCreated :" + healthQPatientCreated);
	}
}
