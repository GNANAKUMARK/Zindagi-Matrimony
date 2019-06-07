package com.matrimony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.entity.UserProfile;
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
		userProfile  = matrimonyRepository.save(userProfile);
		response.setStatus("UserProfile got save successfully with reference Id:"+userProfile.getId());
		return response;
	}

}
