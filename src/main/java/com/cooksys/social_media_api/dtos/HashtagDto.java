package com.cooksys.social_media_api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class HashtagDto {
    private String label;
    private Timestamp firstUsed;
    private Timestamp lastUsed;
}
