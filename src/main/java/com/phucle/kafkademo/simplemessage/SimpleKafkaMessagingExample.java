package com.phucle.kafkademo.simplemessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.phucle.kafkademo.config.KafkaTopicConfig.SIMPLE_MESSAGE_TOPIC;

@Component
@Slf4j
@RequiredArgsConstructor
public class SimpleKafkaMessagingExample {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void execute() {
        log.info("SimpleKafkaMessagingExample is executing...");
        for (int i = 0; i < 100; ++i) {
            kafkaTemplate.send(SIMPLE_MESSAGE_TOPIC, "SimpleKafkaMessaging - Message No = " + i);
        }
    }

    @Bean
    public SimpleKafkaMessageListener simpleKafkaMessageListener() {return new SimpleKafkaMessageListener(); }
}
