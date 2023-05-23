package com.cooksys.social_media_api.mappers;

import com.cooksys.social_media_api.dtos.ProfileRequestDto;
import com.cooksys.social_media_api.embeddables.Profile;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProfileMapper {
    Profile RequestDtoToEntity(ProfileRequestDto profileRequestDto);
}
