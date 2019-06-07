package com.matrimony.service;

import java.util.List;

import com.matrimony.entity.AllProfiles;
import com.matrimony.entity.UserProfile;
import com.matrimony.pojo.GetProfileDTO;

public interface AllProfilesService {

	List<UserProfile> getAllProfiles(Long id);

}
