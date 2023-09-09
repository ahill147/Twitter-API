package com.cooksys.social_media_api.services.impl;

import com.cooksys.social_media_api.dtos.CredentialsDto;
import com.cooksys.social_media_api.dtos.UserRequestDto;
import com.cooksys.social_media_api.dtos.UserResponseDto;
import com.cooksys.social_media_api.entities.Credentials;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.entities.User;
import com.cooksys.social_media_api.exceptions.BadRequestException;
import com.cooksys.social_media_api.exceptions.NotFoundException;
import com.cooksys.social_media_api.mappers.CredentialsMapper;
import com.cooksys.social_media_api.mappers.ProfileMapper;
import com.cooksys.social_media_api.mappers.UserMapper;
import com.cooksys.social_media_api.repositories.UserRepository;
import com.cooksys.social_media_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

	@Override
	public UserResponseDto deleteUser(UserRequestDto userRequestDto, String username) {
		User user = getUserOrThrowError(username);
		boolean validUser = checkUserCredentials(userRequestDto, user);
		if (validUser) {
			user.setDeleted(true);
			userRepository.saveAndFlush(user);
			return userMapper.entityToDto(user);
		} else {
			throw new BadRequestException("Wrong credentials");
		}
	}

	@Override
	public List<UserResponseDto> getUsers() {
		List<User> users = userRepository.findAllByDeletedIsFalse();
		return userMapper.entitiesToDtos(users);
	}

	@Override
	public void followUser(String username, CredentialsDto credentialsDto) {
		User userToFollow = getUserOrThrowError(username);
		User user = getUserOrThrowError(credentialsDto.getUsername());

		addFollowing(user, userToFollow);
		return;
	}

	public void addFollowing(User user, User userToFollow) {
		List<User> following = user.getFollowing();
		following.add(userToFollow);
		addFollower(userToFollow, user);
		user.setFollowing(following);
		userRepository.saveAndFlush(user);
		return;
	}

	public void addFollower(User user, User follower) {
		List<User> followers = user.getFollowers();
		followers.add(follower);
		user.setFollowers(followers);
		userRepository.saveAndFlush(user);
		return;
	}

	private User getUserOrThrowError(String username) {
		Optional<User> user = userRepository.findByCredentialsUsernameAndDeletedFalse(username);
		if (user.isPresent() && !user.get().isDeleted()) {
			return user.get();
		} else {
			throw new BadRequestException("User not found");
		}
	}

	private boolean checkUserCredentials(UserRequestDto userRequestDto, User user) {
		String username = userRequestDto.getCredentials().getUsername();
		String password = userRequestDto.getCredentials().getPassword();

		String userUsername = user.getCredentials().getUsername();
		String userPassword = user.getCredentials().getPassword();

		return username.equals(userUsername) && password.equals(userPassword);
	}

	@Override
	public void unfollowUser(String username, CredentialsDto credentialsDto) {
		User userToFollow = getUserOrThrowError(username);
		User user = getUserOrThrowError(credentialsDto.getUsername());

		unFollowing(user, userToFollow);
		return;

	}

	public void unFollowing(User user, User userToUnfollow) {
		List<User> following = user.getFollowing();
		if (!following.contains(userToUnfollow)) {
			throw new NotFoundException();
		}
		following.remove(userToUnfollow);
		unFollower(userToUnfollow, user);
		user.setFollowing(following);
		userRepository.saveAndFlush(user);
		return;
	}

	public void unFollower(User user, User follower) {
		List<User> followers = user.getFollowers();
		followers.remove(follower);
		user.setFollowers(followers);
		userRepository.saveAndFlush(user);
		return;
	}

	@Override
	public UserResponseDto createMention(String username, Tweet tweet) {

		Optional<User> user = userRepository.findByCredentialsUsernameAndDeletedFalse(username);
		if (!user.isPresent() || user.get().isDeleted()) {
			return null;
		}
		User mention = user.get();
		List<Tweet> mentions = mention.getMentionedTweets();
		mentions.add(tweet);
		mention.setMentionedTweets(mentions);
		return userMapper.entityToDto(userRepository.saveAndFlush(mention));
	}
}