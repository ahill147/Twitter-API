package com.cooksys.social_media_api.services.impl;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

import com.cooksys.social_media_api.dtos.HashtagDto;
import com.cooksys.social_media_api.dtos.TweetResponseDto;
import com.cooksys.social_media_api.entities.Hashtag;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.exceptions.BadRequestException;
import com.cooksys.social_media_api.exceptions.NotFoundException;
import com.cooksys.social_media_api.mappers.HashtagMapper;
import com.cooksys.social_media_api.mappers.TweetMapper;
import com.cooksys.social_media_api.repositories.HashtagRepository;
import com.cooksys.social_media_api.repositories.TweetRepository;
import com.cooksys.social_media_api.services.HashtagService;
import com.cooksys.social_media_api.services.ValidateService;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HashtagServiceImpl implements HashtagService {
	private final HashtagRepository hashtagRepository;
	private final HashtagMapper hashtagMapper;

	public HashtagDto createHashtag(String label, Tweet tweet) {

		if (hashtagRepository.existsByLabel(label))
			throw new BadRequestException("Duplicate hashtag found, skipping processing...");

		Hashtag hashtag = null;
		hashtag.setLabel(label);
		List<Tweet> tweets = new ArrayList<>();
		tweets.add(tweet);
		hashtag.setTweets(tweets);
		return hashtagMapper.entityToDto(hashtagRepository.saveAndFlush(hashtag));
	}
   
}

