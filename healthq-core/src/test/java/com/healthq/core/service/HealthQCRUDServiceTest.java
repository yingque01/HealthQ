package com.healthq.core.service;

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
import com.healthq.core.persistence.TestWithEmbeddedDBBase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HealthQCoreAutoConfiguration.class })
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles("test")
@Slf4j
public class HealthQCRUDServiceTest extends TestWithEmbeddedDBBase {
	//The service test class extends TestWithEmbeddedDBBase for when we need to use embedded MySQL Instance
	@Autowired
	HealthQCRUDService healthQCRUDService;
	
	@Test
	public void testCreateAPatient() {
		HealthQPatients newPatient = new HealthQPatients(
				UUID.randomUUID(), "John", null, "Smith",
				Date.valueOf("1993-01-31"), "Male",
				"yingque210981@gmail.com", "0412023876", "2683952653");
		log.info("The newPatient created is : "+healthQCRUDService.createAPatient(newPatient));
	}
}
