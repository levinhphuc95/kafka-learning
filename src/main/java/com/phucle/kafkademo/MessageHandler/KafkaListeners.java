package com.phucle.kafkademo.MessageHandler;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = {"demoTopic"}, groupId = "demoGroup")
    void listener(String message) {
        System.out.println("Receive message: " + message);
    }
}
