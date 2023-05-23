package com.cooksys.social_media_api.dtos;

import com.cooksys.social_media_api.embeddables.Credentials;
import com.cooksys.social_media_api.embeddables.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRequestDto {

	private Credentials credentials;
	
	private Profile profile;
	
}
