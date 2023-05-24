package com.cooksys.social_media_api.services.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.social_media_api.dtos.HashtagDto;
import com.cooksys.social_media_api.dtos.TweetResponseDto;
import com.cooksys.social_media_api.entities.Hashtag;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.exceptions.NotFoundException;
import com.cooksys.social_media_api.mappers.HashtagMapper;
import com.cooksys.social_media_api.mappers.TweetMapper;
import com.cooksys.social_media_api.repositories.HashtagRepository;
import com.cooksys.social_media_api.repositories.TweetRepository;
import com.cooksys.social_media_api.services.HashtagService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HashtagServiceImpl implements HashtagService {
   
}

