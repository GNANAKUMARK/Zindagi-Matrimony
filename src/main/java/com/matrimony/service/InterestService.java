package com.matrimony.service;

import java.util.List;

import com.matrimony.entity.ProfileInterest;
import com.matrimony.entity.UserProfile;
import com.matrimony.pojo.InterestRequest;
import com.matrimony.pojo.InterestResponse;

public interface InterestService {

	List<ProfileInterest> findRequestById(Long id);

	UserProfile findbyId(Long id);

	List<ProfileInterest> findSentRequestById(Long id);

	InterestResponse save(InterestRequest request);

}
