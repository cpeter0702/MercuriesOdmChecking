package com.firsttech.insurance.odm_checking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OdmCheckingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdmCheckingApplication.class, args);
	}

}