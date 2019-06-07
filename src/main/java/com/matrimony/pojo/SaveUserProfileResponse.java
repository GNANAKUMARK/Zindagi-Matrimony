/**
 * 
 */
package com.matrimony.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author user1
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class SaveUserProfileResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;

}
