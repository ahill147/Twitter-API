package com.cooksys.social_media_api.services.impl;

import com.cooksys.social_media_api.dtos.UserRequestDto;
import com.cooksys.social_media_api.dtos.UserResponseDto;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.entities.User;
import com.cooksys.social_media_api.exceptions.BadRequestException;
import com.cooksys.social_media_api.mappers.CredentialsMapper;
import com.cooksys.social_media_api.mappers.ProfileMapper;
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
    private final CredentialsMapper credentialsMapper;
    private final ProfileMapper profileMapper;

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
        User user = getUserOrThrowError(username);
        return userMapper.entityToDto(user);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto, String username) {
        User user = getUserOrThrowError(username);

        user.getCredentials().setPassword(userRequestDto.getCredentials().getPassword());
        user.getCredentials().setUsername(userRequestDto.getCredentials().getUsername());

        user.getProfile().setEmail(userRequestDto.getProfile().getEmail());
        user.getProfile().setPhone(userRequestDto.getProfile().getPhone());
        user.getProfile().setLastName(userRequestDto.getProfile().getLastName());
        user.getProfile().setFirstName(userRequestDto.getProfile().getFirstName());
        userRepository.saveAndFlush(user);

        return userMapper.entityToDto(user);
    }

    private User getUserOrThrowError(String username) {
        Optional<User> user = userRepository.findByCredentialsUsernameAndDeletedFalse(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new BadRequestException("User not found");
        }
    }
}