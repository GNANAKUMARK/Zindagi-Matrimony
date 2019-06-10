package com.matrimony;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.matrimony.entity.AllProfiles;
import com.matrimony.entity.UserProfile;
import com.matrimony.repository.MatrimonyRepository;
import com.matrimony.service.AllProfilesServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllProfilesServiceTest {
	
	
	
	@Mock
	MatrimonyRepository repository;
	
	@InjectMocks
	AllProfilesServiceImpl service;
	
	@Test
	public void whileFetchingAllProfiles() {
		List<UserProfile> list = new ArrayList<>();
		UserProfile profiles = new UserProfile();
		profiles.setFirstName("Kartjik");
		profiles.setEmailId("kkrpcs@gmail.com");
		list.add(profiles);
		Mockito.when(repository.findAll()).thenReturn(list);
		List<UserProfile> list1 = service.getAllProfiles(1L);
		assertThat(list1).isEqualTo(list);
		
		
	}

}
