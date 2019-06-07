package com.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.UserProfile;

@Repository
public interface MatrimonyRepository extends JpaRepository<UserProfile, Long>{

	@Query(value = "select * from user_profile where user_name=?1 and password=?2",nativeQuery = true)
	UserProfile findByUserNameAndPassword(String userName, String password);
}
