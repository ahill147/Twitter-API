package com.cooksys.social_media_api.mappers;

import org.mapstruct.Mapper;

import com.cooksys.social_media_api.dtos.HashtagDto;
import com.cooksys.social_media_api.entities.Hashtag;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HashtagMapper {
    List<HashtagDto> entitiesToDtos(List<Hashtag> dtos);

    HashtagDto entityToDto(Hashtag hashtag);

    Hashtag dtoToEntity(HashtagDto dto);
}
