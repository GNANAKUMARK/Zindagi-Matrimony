package com.matrimony.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.pojo.LoginRequest;
import com.matrimony.pojo.LoginResponse;
import com.matrimony.pojo.SaveUserProfileResponse;
import com.matrimony.pojo.UserProfileDTO;
import com.matrimony.service.MatrimonyService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class MatrimonyController {
	@Autowired
	MatrimonyService matrimonyService;

	private static final Logger LOGGER = LogManager.getLogger(MatrimonyController.class);

	@PostMapping(value = "/users")
	public ResponseEntity<SaveUserProfileResponse>  saveUserProfile(@RequestBody UserProfileDTO request) {
		LOGGER.info("saveUserProfile inController");
		SaveUserProfileResponse response = matrimonyService.saveUserProfile(request);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	@PostMapping("/users")
	public ResponseEntity<LoginResponse> loginPage(@RequestBody LoginRequest loginRequest){
		
		LoginRequest request = new LoginRequest();
		LoginResponse response = matrimonyService.findByUserNameAndPassword(loginRequest);
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		if(request.getUserName()== userProfileDTO.getUserName() && request.getPassword() == userProfileDTO.getPassword()){
			response.setStatus("Successfully Logged in.....");
			return new ResponseEntity<LoginResponse>(response,HttpStatus.OK);
		}
		
		response.setStatus("No data");
		return new ResponseEntity<LoginResponse>(response,HttpStatus.NOT_FOUND);
		

		
	}


}
