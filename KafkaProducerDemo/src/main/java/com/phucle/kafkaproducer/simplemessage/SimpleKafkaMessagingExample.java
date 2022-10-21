package com.phucle.kafkaproducer.simplemessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.phucle.kafkaproducer.config.KafkaTopicConfig.SIMPLE_MESSAGE_TOPIC;

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

//    @Bean
//    public SimpleKafkaMessageListener simpleKafkaMessageListener() {return new SimpleKafkaMessageListener(); }
}
