package com.phucle.kafkaconsumer.messagelisteners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.phucle.kafkaconsumer.config.KafkaTopicConfig.MULTI_PARTITION_TOPIC;

@Slf4j
@Component
public class MultiPartitionMessageConsumer {

    @KafkaListener(topics = MULTI_PARTITION_TOPIC, groupId = "multiPartitionWith2Consumer")
    public void receiver1a(@Payload String payload,
                           @Header(KafkaHeaders.RECEIVED_PARTITION_ID)Long partitionId,
                           @Header(KafkaHeaders.OFFSET)Long offset) {
        log.info("Received consumer=1a group=multiPartitionWith2Consumer payload='{}' from partitionId={}, offset='{}'", payload, partitionId, offset);
    }

    @KafkaListener(topics = MULTI_PARTITION_TOPIC, groupId = "multiPartitionWith2Consumer")
    public void receiver1b(@Payload String payload,
                           @Header(KafkaHeaders.RECEIVED_PARTITION_ID)Long partitionId,
                           @Header(KafkaHeaders.OFFSET)Long offset) {
        log.info("Received consumer=1b group=multiPartitionWith2Consumer payload='{}' from partitionId={}, offset='{}'", payload, partitionId, offset);
    }

    @KafkaListener(topics = MULTI_PARTITION_TOPIC, containerFactory = "factoryWith6Consumer", groupId = "multiPartitionWithSingleConsumer6Thread")
    public void receiver2(@Payload String payload,
                          @Header(KafkaHeaders.RECEIVED_PARTITION_ID)Long partitionId,
                          @Header(KafkaHeaders.OFFSET)Long offset) {
        log.info("Received consumer=2 group=multiPartitionWithSingleConsumer6Thread payload='{}' from partitionId='{}', offset='{}'", payload, partitionId, offset);
    }
}
