package com.firsttech.insurance.odm_checking.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class OdmPostTesterService {

	@PostConstruct
	public void runOnceAtStartup() {
		sendEMail();
		sendSMS();
		doCronTest();
	}
	
	@Scheduled(cron = "0 0/5 * * * ?")
	public void sendSMS() {
		System.out.println("[OdmPostTesterService] preparing to send SMS .....");
	}
	
	@Scheduled(cron = "0 0/5 * * * ?")
	public void sendEMail() {
		System.out.println("[OdmPostTesterService] preparing to send EMAIL .....");
	}

	@Scheduled(cron = "0 0/10 * * * ?")
	public void doCronTest () {
		doTest(null, null);
	}
	
	public void doTest(String startDate, String endDate) {
		System.out.println("[OdmPostTesterService] preparing to do ODM reuslt checking .....");
		
		String configPath = "D:\\MercuriesOdmChecking\\config.properties";
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
				testODM.createTest("nb", startDate, endDate);
			};
			Runnable TAtest = () -> {
				testODM.createTest("ta", startDate, endDate);
			};

			testODM.executeTest(NBtest);
			testODM.executeTest(TAtest);
			testODM.closeTest();

		}
		System.out.println("-------------------------");
	}

}
