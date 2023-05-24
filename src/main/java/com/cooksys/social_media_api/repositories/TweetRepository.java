package com.cooksys.social_media_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.social_media_api.entities.Tweet;

import java.util.Optional;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
