package com.cooksys.social_media_api.dtos;

import com.cooksys.social_media_api.entities.Tweet;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ContextResponseDto {

	private Tweet target;
	
	private Tweet[] before;
	
	private Tweet[] after;
	
}
