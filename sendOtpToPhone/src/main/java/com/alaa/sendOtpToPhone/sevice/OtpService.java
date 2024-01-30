package com.alaa.sendOtpToPhone.sevice;

import com.alaa.sendOtpToPhone.configuration.OtpTwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {
    private final OtpTwilioConfiguration otpTwilioConfiguration;
    Map<String,String> otpMap=new HashMap<String,String>();

    public OtpService(OtpTwilioConfiguration otpTwilioConfiguration) {
        this.otpTwilioConfiguration = otpTwilioConfiguration;
    }

    public String sendOtpToPhoneNumber( String mobileNumber) {
        String otp=generateOTP();
        PhoneNumber to=new PhoneNumber(mobileNumber);
        PhoneNumber from=new PhoneNumber(otpTwilioConfiguration.getPhoneNumber());
        String msgBody="Your message"+otp;
        Message message=Message.creator(to,from,msgBody).create();
        otpMap.put(msgBody,otp);
                return "otp send successful";
    }

    private String generateOTP() {
        int otp=(int) (Math.random()*1000000);
        return String.format("%06d",otp);
    }
}
