package com.cooksys.social_media_api.services.impl;

import com.cooksys.social_media_api.entities.User;
import com.cooksys.social_media_api.repositories.UserRepository;
import com.cooksys.social_media_api.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidateServiceImpl implements ValidateService {
    private final UserRepository userRepository;

    @Override
    public Boolean validateUsername(String username) {
        Optional<User> user = userRepository.findByCredentialsUsernameAndDeletedFalse(username);
        return !(user.isEmpty());
    }
}
