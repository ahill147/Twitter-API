package com.cooksys.social_media_api.services.impl;

import com.cooksys.social_media_api.dtos.TweetRequestDto;
import com.cooksys.social_media_api.dtos.TweetResponseDto;
import com.cooksys.social_media_api.embeddables.Credentials;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.services.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {
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
}
