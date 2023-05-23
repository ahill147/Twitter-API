package com.cooksys.social_media_api.entities;

import java.sql.Timestamp;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
}