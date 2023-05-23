package com.cooksys.social_media_api.dtos;

import com.cooksys.social_media_api.embeddables.Credentials;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TweetRequestDto {

	private String content;
	
	private Credentials credentials;
}
