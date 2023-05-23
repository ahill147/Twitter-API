package com.cooksys.social_media_api.mappers;

import com.cooksys.social_media_api.dtos.CredentialsRequestDto;
import com.cooksys.social_media_api.embeddables.Credentials;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {
    Credentials RequestDtoToEntity(CredentialsRequestDto credentialsRequestDto);
}
