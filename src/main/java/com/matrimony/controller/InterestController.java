package com.matrimony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.entity.ProfileInterest;
import com.matrimony.service.InterestService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class InterestController {
	
	@Autowired
	InterestService service;
	
	public ResponseEntity<List<ProfileInterest>> getPendingRequests(){
		return null;
		
		
	}
	

}
