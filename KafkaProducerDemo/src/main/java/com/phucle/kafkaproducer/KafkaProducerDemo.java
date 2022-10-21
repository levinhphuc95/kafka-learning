package com.phucle.kafkaproducer;

import com.phucle.kafkaproducer.multipartition.MultiPartitionMessageExample;
import com.phucle.kafkaproducer.simplemessage.SimpleKafkaMessagingExample;
import com.phucle.kafkaproducer.streamapi.KafkaStreamExample;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import static com.phucle.kafkaproducer.config.KafkaTopicConfig.SIMPLE_MESSAGE_TOPIC;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerDemo {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerDemo.class, args);
    }

    private final SimpleKafkaMessagingExample simpleKafkaMessagingExample;
    private final MultiPartitionMessageExample multiPartitionMessageExample;
    private final KafkaStreamExample kafkaStreamExample;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Bean
    public CommandLineRunner kafkaExampleRunner() {
        return args -> {
//            sendLargeNumberOfMessagesToQueue();
//            simpleKafkaMessagingExample.execute();
            multiPartitionMessageExample.execute();
//            kafkaStreamExample.execute();
        };
    }

    private void sendLargeNumberOfMessagesToQueue() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            kafkaTemplate.send(SIMPLE_MESSAGE_TOPIC, "Bulk message " + i);
        }
        long endTime = System.currentTimeMillis();
        log.info("Total send time: {}ms", endTime-startTime);
    }
}