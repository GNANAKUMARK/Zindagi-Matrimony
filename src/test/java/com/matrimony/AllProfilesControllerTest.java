package com.matrimony;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.matrimony.controller.ProfilesController;
import com.matrimony.service.AllProfilesService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AllProfilesControllerTest {

	 private MockMvc mockMvc;
	 
	 @Autowired 
		private WebApplicationContext wac;
		 
		@Before
		public void setup() { 
			this.mockMvc =  MockMvcBuilders.webAppContextSetup(wac).build();
		
	}
		@MockBean
		AllProfilesService service;
		@InjectMocks
		ProfilesController controller;
		
		@Test
		public void whileFetchingAllProfiles() throws Exception {
			mockMvc.perform(get("/api/getAllProfiles/{id}",2).accept(MediaType.
					 APPLICATION_JSON))
					.andExpect(status().isOk()).andDo(print()); 
			
		}
		
		public void whileDataNotFound() {
			
			
		}
}
