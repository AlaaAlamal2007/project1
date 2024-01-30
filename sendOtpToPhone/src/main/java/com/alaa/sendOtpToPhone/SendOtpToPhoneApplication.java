package com.alaa.sendOtpToPhone;

import com.alaa.sendOtpToPhone.configuration.OtpTwilioConfiguration;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SendOtpToPhoneApplication {
	private final OtpTwilioConfiguration otpTwilioConfiguration;

	public SendOtpToPhoneApplication(OtpTwilioConfiguration otpTwilioConfiguration) {
		this.otpTwilioConfiguration = otpTwilioConfiguration;
	}
	@PostConstruct
	public void setup(){
		Twilio.init(otpTwilioConfiguration.getAccountSid(),otpTwilioConfiguration.getAuthToken());
	}

	public static void main(String[] args) {
		SpringApplication.run(SendOtpToPhoneApplication.class, args);
	}

}
