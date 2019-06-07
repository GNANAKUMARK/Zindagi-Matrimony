package com.matrimony.interests.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matrimony.controller.InterestController;
import com.matrimony.entity.ProfileInterest;
import com.matrimony.pojo.InterestRequest;
import com.matrimony.pojo.InterestResponse;
import com.matrimony.service.InterestServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InterestControllerTest {
	
	 private MockMvc mockMvc;
	 
	 @MockBean
	 InterestServiceImpl service;
	 
	 @InjectMocks 
	 InterestController controller;
	 
	 @Autowired 
		private WebApplicationContext wac;
		 
		@Before
		public void setup() { 
			this.mockMvc =  MockMvcBuilders.webAppContextSetup(wac).build();
		
	}
		@Test
		public void whileFetchingPendingRequests() throws Exception {
			List<ProfileInterest> list = new ArrayList<>();
			ProfileInterest interest = new ProfileInterest();
			interest.setId((long) 1);
			interest.setReceiverAge(24);
			interest.setReceiverFirstName("logesh");
			interest.setReceiverLastName("sekar");
			interest.setReceiverSalary(10000.0);
			interest.setReceiverUserId(2L);
			interest.setSenderUserId(2L);
			list.add(interest);
			Mockito.when(service.findRequestById(interest.getReceiverUserId())).thenReturn(list);
			
			mockMvc.perform(get("/api/Requests/{id}",2).accept(MediaType.
					 APPLICATION_JSON))
					.andExpect(status().isOk()).andDo(print()); 
		}
		
		@Test
		public void whileFetchingSendingRequests() throws Exception {
			List<ProfileInterest> list = new ArrayList<>();
			ProfileInterest interest = new ProfileInterest();
			interest.setId((long) 1);
			interest.setReceiverAge(24);
			interest.setReceiverFirstName("logesh");
			interest.setReceiverLastName("sekar");
			interest.setReceiverSalary(10000.0);
			interest.setReceiverUserId(2L);
			interest.setSenderUserId(2L);
			list.add(interest);
			Mockito.when(service.findSentRequestById(interest.getSenderUserId())).thenReturn(list);
			
			mockMvc.perform(get("/api/SentRequests/{id}",2).accept(MediaType.
					 APPLICATION_JSON))
					.andExpect(status().isOk()).andDo(print()); 
		}
		
		@Test
		public void whileSavingInterest() throws Exception {
			InterestRequest request = new InterestRequest();
			request.setId((long) 1);
			request.setReceiverAge(24);
			request.setReceiverFirstName("logesh");
			request.setReceiverLastName("sekar");
			request.setReceiverSalary(10000.0);
			request.setReceiverUserId(2L);
			request.setSenderUserId(2L);
			InterestResponse response = new InterestResponse();
			response.setId((long) 1);
			response.setStatus("success");
			Mockito.when(service.save(request)).thenReturn(response);
			
			mockMvc.perform(post("/api/showInterest").accept(MediaType.
					 APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON) .content(asJsonString(request)))
					.andExpect(jsonPath("$").exists()).andDo(print()); 
			
		}

		 public static String asJsonString(final Object obj) {
		        try {
		            return new ObjectMapper().writeValueAsString(obj);
		        } catch (Exception e) {
		            throw new RuntimeException(e);
		        }
		    }
}
