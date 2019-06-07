package com.matrimony.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Container for UserProfile DTO
 * @author user1
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class UserProfileDTO implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String firstName;

	private String lastName;

	private Long mobile;

	private String city;

	private Double monthlyIncome;

	private String gender;

	private String religion;

	private String qualification;

	private String userName;

	private String password;

	private String emailId;

	private String foodHabit;

	private Integer age;

}
