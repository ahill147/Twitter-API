package com.cooksys.social_media_api.mappers;

import org.mapstruct.Mapper;

import com.cooksys.social_media_api.dtos.HashtagResponseDto;
import com.cooksys.social_media_api.entities.Hashtag;

@Mapper(componentModel = "spring")
public interface HashtagMapper {

	HashtagResponseDto entityToDto(Hashtag entity);
}
