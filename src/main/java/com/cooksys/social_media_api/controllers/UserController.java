package com.cooksys.social_media_api.controllers;

import com.cooksys.social_media_api.dtos.UserRequestDto;
import com.cooksys.social_media_api.dtos.UserResponseDto;
import com.cooksys.social_media_api.entities.Tweet;
import com.cooksys.social_media_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

/*
PATCH   users/@{username}
DELETE  users/@{username}
 */

    @GetMapping("/@{username}")
    public UserResponseDto getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PatchMapping("@{username}")
    public UserResponseDto updateUser(@RequestBody UserRequestDto userRequestDto, @PathVariable String username) {
        return userService.updateUser(userRequestDto, username);
    }

    //############################  MOVE TO VALIDATE CONTROLLER #####################
    // Check whether or not a given hashtag exists
    @GetMapping("validate/tag/exists/{label}")
    public boolean validateHashtag(@PathVariable String label) {
        return userService.validateHashtag(label);
    }
//	#############################################################################

    //Create a new user. If any required fields are missing or the username
    //provided is already taken, send an error.
    //If the given credentials match a previously deleted user, reactivate
    //the deleted user instead of creating a new one
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    //Retrieves the followers of the user with the given username. Only active
    //users should be included in the response (no deleted users).
    //If no active user with the given username exists, throw error.
    @GetMapping("/@{username}/followers")
    public List<UserResponseDto> getFollowers(@PathVariable String username) {
        return userService.getFollowers(username);
    }

    //Retrieves the users followed by the user with the given username.
    //Only active users should be included in the response.
    //If no active user with the given username exists, throw error.
    @GetMapping("/@{username}/following")
    public List<UserResponseDto> getFollowing(@PathVariable String username) {
        return userService.getFollowing(username);
    }

    //Retrieves all non-deleted tweets in which the user with the given username
    //is mentioned. The tweets should appear in reverse-chronological order.
    //If no active user with the given username exists, throw error.
    @GetMapping("/@{username}/mentions")
    public List<Tweet> getMentions(@PathVariable String username) {
        return userService.getMentions(username);
    }

}
