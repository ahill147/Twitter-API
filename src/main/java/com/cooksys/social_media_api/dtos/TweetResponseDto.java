package com.cooksys.social_media_api.dtos;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TweetResponseDto {

	private Long id;
	
	private Long author;
	
	private Timestamp posted;
	
	private boolean deleted;
	
	private String content;
	
	private Long inReplyTo;
	
	private Long repostOf;
	
}
