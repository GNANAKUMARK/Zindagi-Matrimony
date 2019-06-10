package com.matrimony.service;

import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class SmsService {
	
	 private final static String ACCOUNT_SID = "ACdeed5491c3048680ca93a9bbd3a83784";
	   private final static String AUTH_ID = "a662ccd74f20ba2f57be4baa47c124a2";
	    public static final String TWILIO_NUMBER = "+18084001436";
	    
	    static { Twilio.init(ACCOUNT_SID, AUTH_ID); }

	 public void sms() {
		   Message.creator(new PhoneNumber("+919087393629"), new PhoneNumber("+18084001436"),
			         "ZindagiMatrimony!!  You have a request... just login to see..").create();
	   }
}
