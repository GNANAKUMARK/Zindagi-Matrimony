package com.matrimony.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.matrimony.entity.UserProfile;
import com.matrimony.exception.BADRequestException;
import com.matrimony.exception.DataNotFoundException;
import com.matrimony.pojo.LoginRequest;
import com.matrimony.pojo.LoginResponse;
import com.matrimony.pojo.SaveUserProfileResponse;
import com.matrimony.pojo.UserProfileDTO;
import com.matrimony.repository.MatrimonyRepository;

@Service
public class MatrimonyServiceImpl implements MatrimonyService {
	@Autowired
	MatrimonyRepository matrimonyRepository;

	@Override
	public SaveUserProfileResponse saveUserProfile(UserProfileDTO request) {
		UserProfile userProfile = new UserProfile();
		SaveUserProfileResponse response = new SaveUserProfileResponse();
		userProfile.setAge(request.getAge());
		userProfile.setCity(request.getCity());
		userProfile.setEmailId(request.getEmailId());
		userProfile.setFirstName(request.getFirstName());
		userProfile.setLastName(request.getLastName());
		userProfile.setFoodHabit(request.getFoodHabit());
		userProfile.setGender(request.getGender());
		userProfile.setHabit(request.getHabit());
		userProfile.setLastName(request.getLastName());
		userProfile.setMobile(request.getMobile());
		userProfile.setMonthlyIncome(request.getMonthlyIncome());
		userProfile.setPassword(request.getPassword());
		userProfile.setQualification(request.getQualification());
		userProfile.setReligion(request.getReligion());
		userProfile.setUserName(request.getUserName());
		try {
			userProfile = matrimonyRepository.save(userProfile);
		} catch (DataIntegrityViolationException e) {
			throw new BADRequestException("Username and EmailId already register. Please and new Username and Email");
		}
		response.setStatus("UserProfile got save successfully with reference Id:" + userProfile.getId());
		return response;
	}

	@Transactional
	public LoginResponse findByUserNameAndPassword(LoginRequest loginRequest) throws DataNotFoundException {
		UserProfile user = matrimonyRepository.findByUserNameAndPassword(loginRequest.getUserName(),
				loginRequest.getPassword());
		LoginResponse response = new LoginResponse();

		response.setId(user.getId());
		response.setGender(user.getGender());
		response.setUserName(user.getUserName());

		return response;

	}

}
