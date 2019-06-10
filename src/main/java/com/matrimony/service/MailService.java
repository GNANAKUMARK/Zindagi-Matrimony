package com.matrimony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {
	
	 private final static String ACCOUNT_SID = "ACdeed5491c3048680ca93a9bbd3a83784";
	   private final static String AUTH_ID = "a662ccd74f20ba2f57be4baa47c124a2";
	    public static final String TWILIO_NUMBER = "+18084001436";
	    
	   
	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendOTPEmail(String emailId) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailId);
		mail.setSubject("ZindagiMatrmony");
		
		mail.setText("Hey you recieved a new like... Please login to see more details...");
		javaMailSender.send(mail);
	}
	
	public void sendStatusEmail(String emailId, String subject) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailId);
		mail.setSubject("ING BANk Account verification mail!!");
		
		mail.setText("The Payee for adding Beneficiary is");
		javaMailSender.send(mail);
	}
}