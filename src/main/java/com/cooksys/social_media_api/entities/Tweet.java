package com.cooksys.social_media_api.entities;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.Nullable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Tweet {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Long author;
	
	private Timestamp posted;
	
	private boolean deleted;
	
	@Nullable
	private String content;
	
	@Nullable
	@ManyToOne
	@JoinColumn
	private Long inReplyTo;
	
	@Nullable
	@ManyToOne
	@JoinColumn
	private Long respostOf;
	
}
