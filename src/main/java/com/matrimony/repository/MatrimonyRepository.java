package com.matrimony.repository;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.UserProfile;

@Repository
@NamedQuery( name="findByUserNameAndPassword ", query =  "select * from user_profile where user_name=:userName ")

public interface MatrimonyRepository extends JpaRepository<UserProfile, Long>{

	UserProfile findByUserNameAndPassword(String userName, String password);
}
