package com.cooksys.social_media_api.services;

import java.util.List;

import com.cooksys.social_media_api.dtos.HashtagDto;
import com.cooksys.social_media_api.dtos.TweetResponseDto;
import com.cooksys.social_media_api.entities.Hashtag;
import com.cooksys.social_media_api.entities.Tweet;

public interface HashtagService {

	HashtagDto createHashtag(String label, Tweet tweet);
}

