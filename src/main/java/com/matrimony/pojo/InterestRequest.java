package com.matrimony.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterestRequest {

	private Long id;
	private Long senderUserId;
	private Long receiverUserId;
	private String receiverFirstName;
	private String receiverLastName;
	private Integer receiverAge;
	private Double receiverSalary;
}
