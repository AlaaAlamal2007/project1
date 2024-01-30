package com.alaa.sendOtpToPhone.controller;

import com.alaa.sendOtpToPhone.sevice.OtpService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SmsTwilioController {
    private final OtpService otpService;

    public SmsTwilioController(OtpService otpService) {
        this.otpService = otpService;
    }

    @GetMapping("/home")
    public String home(){
        return "Welcome to twilio sms sending message";
    }
@PostMapping("sendOtp")
    public String sendOtp(@RequestParam String mobileNumber){
    return otpService.sendOtpToPhoneNumber(mobileNumber);
    }
}
