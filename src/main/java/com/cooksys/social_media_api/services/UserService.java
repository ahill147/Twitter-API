package com.cooksys.social_media_api.services;

import com.cooksys.social_media_api.dtos.UserRequestDto;
import com.cooksys.social_media_api.dtos.UserResponseDto;
import com.cooksys.social_media_api.entities.Tweet;

import java.util.List;

public interface UserService {

    boolean validateHashtag(String label);

    UserResponseDto createUser(UserRequestDto userRequestDto);

    List<UserResponseDto> getFollowers(String username);

    List<UserResponseDto> getFollowing(String username);

    List<Tweet> getMentions(String username);


    UserResponseDto getUserByUsername(String username);
}
