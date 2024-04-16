package com.example.Main.controllers;

import com.example.Main.services.UserJourneyService;
import com.example.Main.services.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJourneyController {
    private  final UserJourneyService userJourneyService;

    @Autowired
    public UserJourneyController (UserJourneyService userJourneyService){
        this.userJourneyService = userJourneyService;
    }
    @PostMapping("/userjourney")
    public ResponseEntity<JsonNode> getUserJourney(@RequestHeader("Authorization")String auth) {
        return userJourneyService.getUserJourney(auth);
    }

}