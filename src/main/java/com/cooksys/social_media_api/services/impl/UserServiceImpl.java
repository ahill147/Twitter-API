package com.cooksys.social_media_api.services.impl;

import com.cooksys.social_media_api.dtos.UserRequestDto;
import com.cooksys.social_media_api.dtos.UserResponseDto;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.entities.User;
import com.cooksys.social_media_api.exceptions.BadRequestException;
import com.cooksys.social_media_api.mappers.UserMapper;
import com.cooksys.social_media_api.repositories.UserRepository;
import com.cooksys.social_media_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    // Move to validate service ⬇️
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

    @Override
    public UserResponseDto getUserByUsername(String username) {
        Optional<User> user = userRepository.findByCredentialsUsernameAndDeletedFalse(username);
        if (user.isPresent()) {
            return userMapper.entityToDto(user.get());
        } else {
            throw new BadRequestException("User not found");
        }
    }
}