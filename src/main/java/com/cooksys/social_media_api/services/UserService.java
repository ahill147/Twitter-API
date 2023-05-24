package com.cooksys.social_media_api.services;

import java.util.List;

import com.cooksys.social_media_api.dtos.CredentialsDto;
import com.cooksys.social_media_api.dtos.TweetResponseDto;
import com.cooksys.social_media_api.dtos.UserRequestDto;
import com.cooksys.social_media_api.dtos.UserResponseDto;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.entities.User;
import com.cooksys.social_media_api.exceptions.NotAuthorizedException;
import com.cooksys.social_media_api.exceptions.NotFoundException;

public interface UserService {

	boolean validateHashtag(String label);

	UserResponseDto createUser(UserRequestDto userRequestDto);

	List<UserResponseDto> getFollowers(String username);

	List<UserResponseDto> getFollowing(String username);

	List<Tweet> getMentions(String username);

   
}
