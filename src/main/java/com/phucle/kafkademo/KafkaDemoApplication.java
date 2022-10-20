package com.phucle.kafkademo;

import com.phucle.kafkademo.multipartition.MultiPartitionMessageExample;
import com.phucle.kafkademo.simplemessage.SimpleKafkaMessagingExample;
import com.phucle.kafkademo.streamapi.KafkaStreamExample;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    private final SimpleKafkaMessagingExample simpleKafkaMessagingExample;
    private final MultiPartitionMessageExample multiPartitionMessageExample;
    private final KafkaStreamExample kafkaStreamExample;

    @Bean
    public CommandLineRunner kafkaExampleRunner() {
        return args -> {
//            simpleKafkaMessagingExample.execute();
//            multiPartitionMessageExample.execute();
//            kafkaStreamExample.execute();
        };
    }
}
