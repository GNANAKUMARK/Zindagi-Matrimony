/**
 * 
 */
package com.matrimony.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity to store User Profile
 * 
 * @author user1
 *
 */
@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class UserProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "Mobile")
	private Long mobile;

	@Column(name = "City")
	private String city;

	@Column(name = "Monthly_Income")
	private Double monthlyIncome;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "Religion")
	private String religion;

	@Column(name = "Qualification")
	private String qualification;

	@Column(name = "User_Name",unique = true)
	private String userName;

	@Column(name = "Password")
	private String password;

	@Column(name = "Email_Id",unique = true)
	private String emailId;

	@Column(name = "Food_Habits")
	private String foodHabit;

	@Column(name = "Age")
	private Integer age;
	
	@Column(name="Habit")
	private String habit;

}
