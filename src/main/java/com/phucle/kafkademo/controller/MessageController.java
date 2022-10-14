package com.phucle.kafkademo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.phucle.kafkademo.config.KafkaTopicConfig.DEMO_TOPIC;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    void sendMessage(@RequestBody Map<String, String> message) {
        kafkaTemplate.send(DEMO_TOPIC, message.get("message"));
    }
}
