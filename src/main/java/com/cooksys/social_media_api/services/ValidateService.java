package com.cooksys.social_media_api.services;

public interface ValidateService {

	Boolean validateUsername(String username);

	Boolean isUsernameAvailable(String username);
}
