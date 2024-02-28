package com.example.Main.controllers;

import com.example.Main.services.QueueService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController

public class QueueController {
    private  final QueueService queueService ;

    @Autowired
    public  QueueController (QueueService queueService){
        this.queueService = queueService ;
    }

    @PostMapping("/callqueues")
    public ResponseEntity<JsonNode> getAllQueues(@RequestHeader("Authorization")String auth) {
        return queueService.getAllQueues(auth);
    }

    @PatchMapping("/queue/start/{queueId}")
    public ResponseEntity<JsonNode> startQueue(@RequestHeader("Authorization")String auth,@PathVariable String queueId) {
        return queueService.startQueue(auth,queueId );
    }

    @PatchMapping("/queue/stop/{queueId}")
    public ResponseEntity<JsonNode> stopQueue(@RequestHeader("Authorization")String auth,@PathVariable String queueId) {
        return queueService.stopQueue(auth,queueId );
    }
    @PatchMapping("/queue/reset/{queueId}")
    public ResponseEntity<JsonNode> resetQueue(@RequestHeader("Authorization")String auth,@PathVariable String queueId) {
        return queueService.resetQueue(auth,queueId );
    }

    @PostMapping("/queue/reserve/{queueId}")
    public ResponseEntity<JsonNode> reserveQueue(@RequestHeader("Authorization")String auth,@PathVariable String queueId) {
        return queueService.reserveQueue(auth,queueId );
    }
}