package com.firsttech.insurance.odm_checking.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class OdmPostTesterService {

	@PostConstruct
	public void runOnceAtStartup() {
		doTest();
	}
	
	@Scheduled(cron = "0 0/30 * * * ?")
	public void sendSMS() {
		
	}

	@Scheduled(cron = "0 0/10 * * * ?")
	public void doTest() {
		String configPath = "D:\\EclipseSpace\\MercuriesOdmChecking\\odm-checking\\src\\main\\resources\\config.properties";
		ConfigManager config = ConfigManager.getInstance(configPath);
		TestManager testODM = new TestManager(config);

		boolean testflag = testODM.getTestFlag();
		String env = testODM.getEnv();

		if (!testflag == true) {
			System.out.println("Test is off");
			return;
		}

		if ("dev".equals(env)) {
			testODM.initTest();

			Runnable NBtest = () -> {
				testODM.createTest("nb");
			};
			Runnable TAtest = () -> {
				testODM.createTest("ta");
			};

			testODM.executeTest(NBtest);
			testODM.executeTest(TAtest);
			testODM.closeTest();

		}
		System.out.println("-------------------------");
	}

}
