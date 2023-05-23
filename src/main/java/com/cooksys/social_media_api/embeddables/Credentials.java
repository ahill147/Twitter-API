package com.cooksys.social_media_api.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Credentials {
	
	@Column(unique = true)
	private String username;
	
	private String password;
}
