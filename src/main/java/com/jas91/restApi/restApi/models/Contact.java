package com.jas91.restApi.restApi.models;


import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Contact {

	@Id
	public String id;
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	@Setter
	@Builder.Default
	private boolean active = true;

	@Override
	public String toString() {
		return String.format("Contact[id=%s, firstName='%s', lastName='%s', email='%s']", id, firstName, lastName,
				email);
	}

}