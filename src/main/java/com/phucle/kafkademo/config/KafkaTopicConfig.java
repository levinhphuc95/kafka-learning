package com.phucle.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String DEMO_TOPIC = "demoTopic";

    @Bean
    public NewTopic demoTopic() {
        return TopicBuilder.name(DEMO_TOPIC)
                .build();
    }
}
