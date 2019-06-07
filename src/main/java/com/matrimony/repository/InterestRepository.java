package com.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.ProfileInterest;

@Repository
public interface InterestRepository extends JpaRepository<ProfileInterest,Long>{

	@Query(value = "select * from profile_interest where receiver_user_id=?1",nativeQuery = true)
	List<ProfileInterest> findRequestById(Long id);
	@Query(value = "select * from profile_interest where sender_user_id=?1",nativeQuery = true)
	List<ProfileInterest> findSentRequestById(Long id);

}
