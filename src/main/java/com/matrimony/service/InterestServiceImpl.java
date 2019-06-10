package com.matrimony.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.entity.ProfileInterest;
import com.matrimony.entity.UserProfile;
import com.matrimony.pojo.InterestRequest;
import com.matrimony.pojo.InterestResponse;
import com.matrimony.repository.InterestRepository;
import com.matrimony.repository.MatrimonyRepository;

@Service
@SuppressWarnings(value = { "all" })
public class InterestServiceImpl implements InterestService{

	@Autowired
	InterestRepository repository;
	
	@Autowired
	SmsService smsService;
	
	
	@Autowired
	MailService mailService;
	@Autowired
	MatrimonyRepository repo;
	
	public List<ProfileInterest> findRequestById(Long id) {
		
		return repository.findRequestById(id);
	}

	@Override
	public UserProfile findbyId(Long id) {
		
		return repo.findById(id).orElse(null);
	}


	public List<ProfileInterest> findSentRequestById(Long id) {
		
		return repository.findSentRequestById(id);
	}

	@Override
	public InterestResponse save(InterestRequest request) {
		String mail =request.getReceiverEmail();
		InterestResponse response = new InterestResponse();
		ProfileInterest interest = new ProfileInterest();
		interest.setReceiverAge(request.getReceiverAge());
		interest.setReceiverFirstName(request.getReceiverFirstName());
		interest.setReceiverLastName(request.getReceiverLastName());
		interest.setReceiverSalary(request.getReceiverSalary());
		interest.setReceiverUserId(request.getReceiverUserId());
		interest.setSenderUserId(request.getSenderUserId());
		 try {
				//mailService.sendOTPEmail(mail);
			 smsService.sms();
			} catch(Exception e) {
				
			}
		 interest = repository.save(interest);
		
		 response.setId(interest.getId());
		 
		return response;
		
		
	}

}
