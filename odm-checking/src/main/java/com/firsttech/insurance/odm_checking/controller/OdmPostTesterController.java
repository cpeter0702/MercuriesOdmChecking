package com.firsttech.insurance.odm_checking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firsttech.insurance.odm_checking.service.OdmPostTesterService;

@RestController
@RequestMapping("/api")
public class OdmPostTesterController {
	private OdmPostTesterService odmPostTesterService;
	
	
	@Autowired
	public OdmPostTesterController (OdmPostTesterService odmPostTesterService) {
		this.odmPostTesterService = odmPostTesterService;
	}
	
	@PostMapping("/callODMResultChecking")
	public String callODMResultChecking() {
		odmPostTesterService.doTest();
		return "API calling doTest has done .....";
	}
	
	
	@PostMapping("/sendSMS")
	public String sendSMS() {
		odmPostTesterService.sendSMS();
		return "API calling sendSMS has done .....";
	}
	
	
}
