package com.cooksys.social_media_api.services;

import java.util.List;

import com.cooksys.social_media_api.dtos.TweetRequestDto;
import com.cooksys.social_media_api.dtos.TweetResponseDto;
import com.cooksys.social_media_api.entities.Credentials;
import com.cooksys.social_media_api.entities.Tweet;

public interface TweetService {

	List<Tweet> getTweets();

	TweetResponseDto postTweet(TweetRequestDto tweetRequestDto);

	TweetResponseDto getTweet(Long id);

	TweetResponseDto deleteTweet(Long id);

	void likeTweet(Long id, Credentials credentials);

}
