/**
 * 
 */
package com.matrimony;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matrimony.controller.MatrimonyController;
import com.matrimony.pojo.SaveUserProfileResponse;
import com.matrimony.pojo.UserProfileDTO;
import com.matrimony.service.MatrimonyService;

/**
 * 
 * @author user1
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = MatrimonyController.class, secure = false)
public class SaveUserProfileControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MatrimonyService service;

	@Test
	public void saveBeneficiary() throws Exception {
		UserProfileDTO dto = new UserProfileDTO();
		SaveUserProfileResponse response = new SaveUserProfileResponse();
		Mockito.when(service.saveUserProfile(dto)).thenReturn(response);
		mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(asJsonString(dto)))
				.andExpect(status().isCreated());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
