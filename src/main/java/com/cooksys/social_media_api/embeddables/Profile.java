package com.cooksys.social_media_api.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Profile {

	@Column(nullable = true)
	private String firstName;
	
	@Column(nullable = true)
	private String lastName;
	
	private String email;
	
	@Column(nullable = true)
	private String phone;
}
