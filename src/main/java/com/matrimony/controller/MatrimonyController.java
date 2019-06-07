package com.matrimony.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	SaveUserProfileResponse saveUserProfile(@RequestBody UserProfileDTO request) {
		LOGGER.info("saveUserProfile inController");
		SaveUserProfileResponse response = matrimonyService.saveUserProfile(request);
		return response;
	}

}
