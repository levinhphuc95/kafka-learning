package com.phucle.kafkademo.multipartition;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static com.phucle.kafkademo.config.KafkaTopicConfig.MULTI_PARTITION_TOPIC;

@Component
@Slf4j
@RequiredArgsConstructor
public class MultiPartitionMessageExample {
    private final MultiPartitionMessageProducer sender;

    public void execute() {
        log.info("MultiPartitionMessagingExample is executing...");
        for (int i = 0; i < 30; ++i) {
            for (int partitionKey = 1; partitionKey <= 10; ++partitionKey) {
                sender.send(MULTI_PARTITION_TOPIC, "key" + partitionKey, "MultiPartitionMessaging - Message No = " + partitionKey + "-" + i);
            }
        }
    }


    @Bean
    public MultiPartitionMessageConsumer consumer() { return new MultiPartitionMessageConsumer(); }

}