package com.matrimony.service;

import com.matrimony.pojo.LoginRequest;
import com.matrimony.pojo.LoginResponse;
import com.matrimony.pojo.SaveUserProfileResponse;
import com.matrimony.pojo.UserProfileDTO;

public interface MatrimonyService {
	SaveUserProfileResponse saveUserProfile(UserProfileDTO request);
	LoginResponse findByUserNameAndPassword(LoginRequest loginRequest);
}
