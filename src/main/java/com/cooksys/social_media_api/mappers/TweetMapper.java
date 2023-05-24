package com.cooksys.social_media_api.mappers;

import org.mapstruct.Mapper;

import com.cooksys.social_media_api.dtos.TweetRequestDto;
import com.cooksys.social_media_api.dtos.TweetResponseDto;
import com.cooksys.social_media_api.entities.Tweet;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface TweetMapper {

    TweetResponseDto entityToDto(Tweet tweet);

    Tweet responseDtoToEntity(TweetResponseDto tweetResponseDto);

    Tweet requestDtoToEntity(TweetRequestDto tweetRequestDto);

    List<TweetResponseDto> entitiesToDtos(List<Tweet> tweets);

}
