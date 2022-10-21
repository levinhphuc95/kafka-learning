package com.phucle.kafkaconsumer.messagelisteners;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.phucle.kafkaconsumer.config.KafkaTopicConfig.STREAM_PROCESSED_DATA_TOPIC;

@Slf4j
@Component
public class SimpleKafkaMessageConsumerForStreaming {
    @KafkaListener(topics = STREAM_PROCESSED_DATA_TOPIC, containerFactory = "factoryForCountConsumer", groupId = "kafkaStreamConsumerGroup")
    public void receive(ConsumerRecord<String, String> record) {
        log.info("Received key='{}' payload='{}'", record.key(), record.value());
    }
}
