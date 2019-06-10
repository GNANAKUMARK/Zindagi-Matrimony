package com.matrimony.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.entity.UserProfile;
import com.matrimony.repository.MatrimonyRepository;

@Service
public class AllProfilesServiceImpl implements AllProfilesService{

	@Autowired
	MatrimonyRepository matrimonyRepository;
	@Override
	public List<UserProfile> getAllProfiles(Long id) {
		
		return matrimonyRepository.findAll(); 
	}

}
