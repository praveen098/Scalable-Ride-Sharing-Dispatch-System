package com.praveen.rideshare.ws.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ws")
@RequiredArgsConstructor
public class BroadcastController {

    private final SimpMessagingTemplate broker;

    @PostMapping("/broadcast")
    public ResponseEntity<?> broadcast(@RequestBody BroadcastRequest req) {
        if (req.topic == null || req.topic.isBlank()) {
            return ResponseEntity.badRequest().body("topic is required");
        }
        // Send JSON payload to subscribers of /topic/{topic}
        broker.convertAndSend("/topic/" + req.topic, req.payload);
        return ResponseEntity.ok().build();
    }

    @Data
    public static class BroadcastRequest {
        private String topic;
        private Object payload; // any JSON
    }
}
