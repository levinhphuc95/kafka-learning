package com.phucle.kafkaconsumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String SIMPLE_MESSAGE_TOPIC = "kafkaSimpleMessageTopic";
    public static final String MULTI_PARTITION_TOPIC = "kafkaMultiPartitionTopic";
    public static final String BATCH_CONSUMER_TOPIC = "kafkaBatchConsumerTopic";
    public static final String STREAM_RAW_DATA_TOPIC = "kafkaStreamRawDataTopic";
    public static final String STREAM_PROCESSED_DATA_TOPIC = "kafkaStreamProcessedDataTopic";

//    @Bean
//    public NewTopic kafkaSimpleMessageTopic() {
//        return TopicBuilder.name(SIMPLE_MESSAGE_TOPIC)
//                .build();
//    }
//
//    @Bean
//    public NewTopic kafkaMultiPartitionTopic() {
//        return TopicBuilder.name(MULTI_PARTITION_TOPIC)
//                .partitions(5)
//                .build();
//    }
//
//    @Bean
//    public NewTopic kafkaBatchConsumerTopic() {
//        return TopicBuilder.name(BATCH_CONSUMER_TOPIC)
//                .build();
//    }
//
//    @Bean
//    public NewTopic kafkaStreamRawDataTopic() {
//        return TopicBuilder.name(STREAM_RAW_DATA_TOPIC)
//                .build();
//    }
//
//    @Bean
//    public NewTopic kafkaStreamProcessedDataTopic() {
//        return TopicBuilder.name(STREAM_PROCESSED_DATA_TOPIC)
//                .build();
//    }
}
