package com.matrimony.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.entity.ProfileInterest;
import com.matrimony.entity.UserProfile;
import com.matrimony.exception.DataNotFoundException;
import com.matrimony.pojo.InterestRequest;
import com.matrimony.pojo.InterestResponse;
import com.matrimony.service.InterestService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class InterestController {
	
	@Autowired
	InterestService service;
	
	
	@GetMapping("/Requests/{id}")
	public ResponseEntity<List<UserProfile>> getPendingRequests(@PathVariable("id") Long id){
		List<ProfileInterest> list = service.findRequestById(id);
		if(list.isEmpty()) {
			throw new DataNotFoundException("You are not having any request");
		}
		List<UserProfile> list1 = new ArrayList<>();
		for (ProfileInterest profileInterest : list) {
			
			UserProfile user = service.findbyId(profileInterest.getSenderUserId());
			list1.add(user);
		}
		
		return new ResponseEntity<>(list1, HttpStatus.OK);	
	}
	
	
	@GetMapping("/SentRequests/{id}")
	public ResponseEntity<List<UserProfile>> getSentRequests(@PathVariable("id") Long id){
		List<ProfileInterest> list = service.findSentRequestById(id);
		if(list.isEmpty()) {
			throw new DataNotFoundException("You have not yet sent any request");
		}
		List<UserProfile> list1 = new ArrayList<>();
		for (ProfileInterest profileInterest : list) {
			
			UserProfile user = service.findbyId(profileInterest.getReceiverUserId());
			list1.add(user);
		}
		return new ResponseEntity<>(list1, HttpStatus.OK);
	}

	
	@PostMapping("/showInterest")
	public ResponseEntity<InterestResponse> saveInterest(@RequestBody InterestRequest request) {
		InterestResponse response =new InterestResponse();
		String msg ="Success";
		try {
		 response =service.save(request);
		}
		catch (Exception e) {
			msg = "Failure";
			
		}
		response.setStatus(msg);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		
	}
}
