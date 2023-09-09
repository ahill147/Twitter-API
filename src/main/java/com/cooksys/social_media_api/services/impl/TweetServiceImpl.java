package com.cooksys.social_media_api.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cooksys.social_media_api.dtos.TweetRequestDto;
import com.cooksys.social_media_api.dtos.TweetResponseDto;
import com.cooksys.social_media_api.entities.Credentials;
import com.cooksys.social_media_api.entities.Hashtag;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.entities.User;
import com.cooksys.social_media_api.exceptions.BadRequestException;
import com.cooksys.social_media_api.mappers.CredentialsMapper;
import com.cooksys.social_media_api.mappers.HashtagMapper;
import com.cooksys.social_media_api.mappers.TweetMapper;
import com.cooksys.social_media_api.mappers.UserMapper;
import com.cooksys.social_media_api.repositories.TweetRepository;
import com.cooksys.social_media_api.repositories.UserRepository;
import com.cooksys.social_media_api.services.HashtagService;
import com.cooksys.social_media_api.services.TweetService;
import com.cooksys.social_media_api.services.UserService;
import com.cooksys.social_media_api.services.ValidateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {
	private final TweetRepository tweetRepository;
	private final TweetMapper tweetMapper;
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final UserService userService;
	private final CredentialsMapper credentialsMapper;
	private final HashtagMapper hashtagMapper;
	private final HashtagService hashtagService;
	private final ValidateService validateService;
	
	@Override
    public List<Tweet> getTweets() {
        return null;
    }

    @Override
    public TweetResponseDto postTweet(TweetRequestDto tweetRequestDto) {
        return null;
    }

    @Override
    public TweetResponseDto getTweet(Long id) {
        return null;
    }

    @Override
    public TweetResponseDto deleteTweet(Long id) {
        return null;
    }

    @Override
    public void likeTweet(Long id, Credentials credentials) {

    }

	@Override
	public TweetResponseDto replyToTweet(Long id, TweetRequestDto tweetRequestDto) {
		try {
			Credentials credentials = credentialsMapper.dtoToEntity(tweetRequestDto.getCredentials());
			if(userRepository.findByCredentialsUsernameAndDeletedIsFalse(credentials.getUsername()) == null)
				throw new BadRequestException("Given author does not exist or is deleted.");
			User user = userRepository.findByCredentialsUsernameAndDeletedIsFalse(credentials.getUsername());
			Tweet tweet = tweetMapper.requestDtoToEntity(tweetRequestDto);
			Tweet tweetToReplyTo = tweetRepository.getById(id);
			if (tweetToReplyTo == null) {
				throw new BadRequestException();
			}
			String content = tweetRequestDto.getContent();

			if (content == null) {
				throw new BadRequestException();
			}
			tweet.setAuthor(user);
			tweet.setContent(content);
			tweet.setInReplyTo(tweetToReplyTo);
			addToReplies(tweetToReplyTo, tweet);
			List<Hashtag> hashtags = extractHashtags(content, tweet);
			tweet.setHashtags(hashtags);
			List<User> mentions = extractMentions(content, tweet);
			tweet.setMentionedUsers(mentions);
			return tweetMapper.entityToDto(tweetRepository.saveAndFlush(tweet));
		} catch (Exception e) {
			throw new BadRequestException("Given username is either deleted or does not exist.");
		}
	}
	
	public void addToReplies(Tweet tweet, Tweet reply) {
		List<Tweet> replies = tweet.getReplies();
		replies.add(reply);
		tweet.setReplies(replies);
		tweetRepository.saveAndFlush(tweet);
		return;
	}
	
	private List<User> extractMentions(String content, Tweet tweet) {

		Set<User> mentions = new HashSet<>();

		String[] words = content.split("\\s+");
		for (String word : words) {
			if (word.startsWith("@")) {
				String temp = word.substring(1);
				User mention = null;
				mention = userMapper.responseDtoToEntity(userService.createMention(temp, tweet));
				if (mention != null)
					mentions.add(mention);
			}
		}
		return new ArrayList<User>(mentions);
	}
	
	private List<Hashtag> extractHashtags(String content, Tweet tweet) {

		Set<Hashtag> hashtags = new HashSet<>();

		String[] words = content.split("\\s+");
		for (String word : words) {
			if (word.startsWith("#")) {
				String temp = word.substring(1);
				Hashtag hashtag = null;
				hashtag = hashtagMapper.dtoToEntity(hashtagService.createHashtag(temp, tweet));
				if (hashtag != null)
					hashtags.add(hashtag);
			}
		}
		return new ArrayList<Hashtag>(hashtags);
	}
    
   
}
