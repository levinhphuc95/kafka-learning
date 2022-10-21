package com.phucle.kafkaconsumer.messagelisteners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.phucle.kafkaconsumer.config.KafkaTopicConfig.SIMPLE_MESSAGE_TOPIC;

@Slf4j
@Component
public class SimpleKafkaMessageListener {

    @KafkaListener(topics = SIMPLE_MESSAGE_TOPIC, groupId = "simpleMessageGroup")
    public void listener(String payload) {
        log.info("Received payload='{}'", payload);
    }
}
