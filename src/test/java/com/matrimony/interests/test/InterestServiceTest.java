package com.matrimony.interests.test;

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

import com.matrimony.entity.ProfileInterest;
import com.matrimony.repository.InterestRepository;
import com.matrimony.service.InterestServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterestServiceTest {

	@Mock
	InterestRepository repository;

	@InjectMocks
	InterestServiceImpl service;

	@Test
	public void whileFetchingPendingRequests() {
		List<ProfileInterest> list = new ArrayList<>();
		ProfileInterest interest = new ProfileInterest();
		interest.setId((long) 1);
		interest.setReceiverAge(24);
		interest.setReceiverFirstName("logesh");
		interest.setReceiverLastName("sekar");
		interest.setReceiverSalary(10000.0);
		interest.setReceiverUserId(1L);
		interest.setSenderUserId(2L);
		list.add(interest);
		Mockito.when(repository.findRequestById(2L)).thenReturn(list);
		List<ProfileInterest> list1 = service.findRequestById(2L);
		assertThat(list1).isEqualTo(list);
	}

}
