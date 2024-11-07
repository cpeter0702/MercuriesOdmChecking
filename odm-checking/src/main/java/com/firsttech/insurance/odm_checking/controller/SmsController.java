package com.firsttech.insurance.odm_checking.controller;

import com.firsttech.insurance.odm_checking.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @GetMapping("/send-sms")
    public String sendEmail() {
        smsService.sendSMS();
        return "SMS sent successfully";
    }
}
