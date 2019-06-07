package com.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.ProfileInterest;

@Repository
public interface InterestRepository extends JpaRepository<ProfileInterest,Long>{

}
