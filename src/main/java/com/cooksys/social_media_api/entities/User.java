package com.cooksys.social_media_api.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cooksys.social_media_api.embeddables.Credentials;
import com.cooksys.social_media_api.embeddables.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "User_Table")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private Credentials credentials;
	
	@Embedded
	private Profile profile;
	
	private Timestamp joined;
	
	private boolean deleted;
	
	@ManyToMany(mappedBy = "userLikes")
	private Set<Tweet> tweetsLiked = new HashSet<>();
	
	@OneToMany(mappedBy = "author")
	private Set<Tweet> tweets = new HashSet<>();
	
	@ManyToMany(mappedBy = "following")
	private Set<User> followers = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "followers_following")
	private Set<User> following = new HashSet<>();
	
	@ManyToMany(mappedBy = "mentionedUsers")
	private Set<Tweet> mentionedTweets = new HashSet<>();
	
	
}