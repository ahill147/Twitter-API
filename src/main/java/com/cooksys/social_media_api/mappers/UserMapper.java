package com.cooksys.social_media_api.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.social_media_api.dtos.UserRequestDto;
import com.cooksys.social_media_api.dtos.UserResponseDto;
import com.cooksys.social_media_api.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	User requestDtoToEntity(UserRequestDto userRequestDto);
	
	UserResponseDto entityToDto(User entity);
	
	List<UserResponseDto> entitiesToDtos(List<User> entities);
}
