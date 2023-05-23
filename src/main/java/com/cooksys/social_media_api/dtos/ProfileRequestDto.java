package com.cooksys.social_media_api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@Data
public class ProfileRequestDto {
    private String firstName;

    private String lastName;

    private String email;

    private String phone;
}
