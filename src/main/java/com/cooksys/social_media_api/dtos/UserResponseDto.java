package com.cooksys.social_media_api.dtos;

import java.sql.Timestamp;

import com.cooksys.social_media_api.embeddables.Credentials;
import com.cooksys.social_media_api.embeddables.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserResponseDto {

	private Long id;

	private Credentials credentials;
	
	private Profile profile;
	
	private Timestamp joined;
	
	private boolean deleted;
}
