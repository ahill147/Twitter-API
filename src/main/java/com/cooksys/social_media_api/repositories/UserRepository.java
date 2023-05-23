package com.cooksys.social_media_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.social_media_api.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
