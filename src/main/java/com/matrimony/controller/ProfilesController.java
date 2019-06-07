package com.matrimony.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor.MatchCallback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.entity.AllProfiles;
import com.matrimony.entity.UserProfile;
import com.matrimony.service.AllProfilesService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class ProfilesController {
	
	@Autowired
	 AllProfilesService allProfilesService;
	
	@GetMapping(value = "/getAllProfiles/{id}")
	public ResponseEntity<List<AllProfiles>> getAllProfilesforId(@PathVariable("id") Long id )
			throws Exception {
		String gender = "";
		int age = 0;
		String city = "";
		Double income =0.0 ;
		String habit = "";
		String foodHabit = "";
		String religion = "";
		List<UserProfile> allProfilesList = new ArrayList<UserProfile>();
		List<AllProfiles> sortedList = new ArrayList<AllProfiles>();
		//AllProfiles allProfiles = null;
		
		try {
			allProfilesList = allProfilesService.getAllProfiles(id);
			for(UserProfile eachProfile : allProfilesList) {
				
				//AllProfiles allProfiles = new AllProfiles();
				if (eachProfile.getId() == id) {
					gender = eachProfile.getGender().trim();
					age = eachProfile.getAge();
					city = eachProfile.getCity();
					income = eachProfile.getMonthlyIncome();
					foodHabit = eachProfile.getFoodHabit();
					habit = eachProfile.getHabit();
					religion = eachProfile.getReligion();
							
				}
			
			}
			for(UserProfile eachProfile : allProfilesList) {
				int matchCount = 0;
				AllProfiles allProfiles = new AllProfiles();
				if (eachProfile.getId() == id) {
					continue;
				}
				
				if (eachProfile.getGender().trim().equalsIgnoreCase(gender)) {
					continue;
				}
				if(age > eachProfile.getAge() ) {
					if((age - eachProfile.getAge()) < 4 ) {
						matchCount = 20;
					}
					
				}
				if(eachProfile.getCity().trim().equalsIgnoreCase(city)) {
					matchCount = matchCount +16;
				}
				if(eachProfile.getFoodHabit().trim().equalsIgnoreCase(foodHabit)) {
					matchCount = matchCount +16;
				}
				
				  if(eachProfile.getHabit().trim().equalsIgnoreCase(habit)) { matchCount =
				  matchCount +16; }
				 
				if(eachProfile.getMonthlyIncome() > income) {
					matchCount = matchCount +16;
				}
				if(eachProfile.getReligion().trim().equalsIgnoreCase(religion)) {
					matchCount = matchCount +16;
				}
				allProfiles.setAge(eachProfile.getAge());
				allProfiles.setLastName(eachProfile.getLastName());
				allProfiles.setFirstName(eachProfile.getFirstName());
				allProfiles.setMonthlyIncome(eachProfile.getMonthlyIncome());
				allProfiles.setMatchScore(matchCount);
				allProfiles.setFoodHabit(eachProfile.getFoodHabit());
				allProfiles.setHabit(eachProfile.getFoodHabit());
				allProfiles.setId(eachProfile.getId());
				sortedList.add(allProfiles);
				
			
			}
			
		
		} catch (Exception e) {
		
			throw e;
		}
		return new ResponseEntity<List<AllProfiles>>(sortedList, HttpStatus.OK);

	}
	

}
