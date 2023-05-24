package com.cooksys.social_media_api.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.social_media_api.dtos.UserRequestDto;
import com.cooksys.social_media_api.dtos.UserResponseDto;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Override
    public boolean validateHashtag(String label) {
        return false;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public List<UserResponseDto> getFollowers(String username) {
        return null;
    }

    @Override
    public List<UserResponseDto> getFollowing(String username) {
        return null;
    }

    @Override
    public List<Tweet> getMentions(String username) {
        return null;
    }
}