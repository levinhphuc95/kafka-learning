package com.phucle.kafkademo.simplemessage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import static com.phucle.kafkademo.config.KafkaTopicConfig.SIMPLE_MESSAGE_TOPIC;

@Slf4j
public class SimpleKafkaMessageListener {

    @KafkaListener(topics = SIMPLE_MESSAGE_TOPIC, groupId = "simpleMessageGroup")
    public void listener(String payload) {
        log.info("Received payload='{}'", payload);
    }
}
