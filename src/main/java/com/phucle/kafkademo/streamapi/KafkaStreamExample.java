package com.phucle.kafkademo.streamapi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.phucle.kafkademo.config.KafkaTopicConfig.STREAM_RAW_DATA_TOPIC;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaStreamExample {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void execute() {
        log.info("KafkaStreamExample is executing...");
        for (int i = 0; i < 10; ++i) {
            kafkaTemplate.send(STREAM_RAW_DATA_TOPIC, "SimpleKafkaMessaging - Message No = " + i);
        }
    }

    @Bean
    public SimpleKafkaMessageConsumerForStreaming simpleKafkaMessageConsumerForStreaming() { return new SimpleKafkaMessageConsumerForStreaming(); }
}
