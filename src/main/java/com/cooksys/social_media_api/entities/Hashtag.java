package com.cooksys.social_media_api.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Hashtag {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String label;
	
	private Timestamp firstUsed;
	
	private Timestamp lastUsed;

	@ManyToMany
	@JoinTable(name = "tweet_hashtags")
	private Set<Tweet> tweetHashtags = new HashSet<>();
}
