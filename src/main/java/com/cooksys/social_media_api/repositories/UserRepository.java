package com.cooksys.social_media_api.repositories;

import com.cooksys.social_media_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCredentialsUsernameAndDeletedFalse(String username);
}
