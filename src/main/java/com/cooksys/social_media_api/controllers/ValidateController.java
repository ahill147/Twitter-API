package com.cooksys.social_media_api.controllers;

import com.cooksys.social_media_api.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/validate")
public class ValidateController {
    private final ValidateService validateService;

    @GetMapping("/username/exists/@{username}")

    public Boolean validateUsername(@PathVariable String username) {
        return validateService.validateUsername(username);
    }

}
