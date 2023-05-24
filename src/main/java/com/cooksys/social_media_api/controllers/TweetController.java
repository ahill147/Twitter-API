package com.cooksys.social_media_api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.social_media_api.dtos.TweetRequestDto;
import com.cooksys.social_media_api.dtos.TweetResponseDto;
import com.cooksys.social_media_api.entities.Credentials;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.services.TweetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets")
public class TweetController {

private final TweetService tweetService;
	
	//Retrieves all non-deleted tweets. They should appear in reverse-chronological order
	@GetMapping
	public List<Tweet> getTweets() {
		return tweetService.getTweets();
	}
	
	//Creates a new simple tweet, with the author set to the user identified by the
	//credentials in the request body. If the given credentials do not match an active
	//user in the database, throw error.
	//Because this always creates a simple tweet, it must have a content property
	//and may not have inReplyTo or respostOf properties
	//IMPORTANT: when a tweet with content is created, the server must process the 
	//tweets content for @{username} mentions and #{hashtags} tags. There is no way
	//to create hashtags or create mentions from the API, so this must be handled automatically
	@PostMapping
	public TweetResponseDto postTweet(TweetRequestDto tweetRequestDto) {
		return tweetService.postTweet(tweetRequestDto);
	}
	
	//Retrieves a tweet with given id. If no such tweet exists, or is deleted, throw error
	@GetMapping("/{id}")
	public TweetResponseDto getTweet(@PathVariable Long id) {
		return tweetService.getTweet(id);
	}
	
	//"Deletes" tweet with given id. If no such tweet exists or provided credentials do not match author,
	//throw error. If tweet is successfully "deleted", response should contain tweet data prior to deletion.
	@DeleteMapping("/{id}")
	public TweetResponseDto deleteTweet(@PathVariable Long id) {
		return tweetService.deleteTweet(id);
	}
	
	//Creates a 'like' relationship between the tweet with the given id and the user whose credentials
	//are provided by the request body. If given tweet is deleted or doesn't exist, or if credentials do not
	//match an active user in the DB, throw error. On success, no response body is sent.
	@PostMapping("/{id}/like")
	public void likeTweet(@PathVariable Long id, @RequestBody Credentials credentials) {
		tweetService.likeTweet(id, credentials);
	}
}
