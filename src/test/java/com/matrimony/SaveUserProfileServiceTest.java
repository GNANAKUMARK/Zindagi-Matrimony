/**
 * 
 */
package com.matrimony;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.matrimony.entity.UserProfile;
import com.matrimony.pojo.LoginRequest;
import com.matrimony.pojo.LoginResponse;
import com.matrimony.pojo.SaveUserProfileResponse;
import com.matrimony.pojo.UserProfileDTO;
import com.matrimony.repository.MatrimonyRepository;
import com.matrimony.service.MatrimonyServiceImpl;

/**
 * 
 * @author user1
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SaveUserProfileServiceTest {
	@Mock
	MatrimonyRepository repo;

	@InjectMocks
	MatrimonyServiceImpl service;

	@Test
	public void saveuserProfile() {
		UserProfile userProfile = new UserProfile();
		userProfile.setId(1l);
		Mockito.when(repo.save(Matchers.anyObject())).thenReturn(userProfile);
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		userProfileDTO.setId(1l);
		SaveUserProfileResponse response = service.saveUserProfile(userProfileDTO);
		assertNotNull(response.getStatus());
	}	

	

}
