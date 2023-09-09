package com.cooksys.social_media_api.services;

import com.cooksys.social_media_api.dtos.CredentialsDto;
import com.cooksys.social_media_api.dtos.UserRequestDto;
import com.cooksys.social_media_api.dtos.UserResponseDto;
import com.cooksys.social_media_api.entities.Credentials;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.entities.User;

import java.util.List;

public interface UserService {

    boolean validateHashtag(String label);

    UserResponseDto createUser(UserRequestDto userRequestDto);

    List<UserResponseDto> getFollowers(String username);

    List<UserResponseDto> getFollowing(String username);

    List<Tweet> getMentions(String username);


    UserResponseDto getUserByUsername(String username);

    UserResponseDto updateUser(UserRequestDto userRequestDto, String username);

    UserResponseDto deleteUser(UserRequestDto userRequestDto, String username);

	List<UserResponseDto> getUsers();
	
	void followUser(String username, CredentialsDto credentials);

	void unfollowUser(String username, CredentialsDto credentials);
	
	UserResponseDto createMention(String username, Tweet tweet);
	
	
}
