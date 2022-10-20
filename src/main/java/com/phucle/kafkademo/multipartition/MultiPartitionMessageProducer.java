package com.phucle.kafkademo.multipartition;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

@Slf4j
@RequiredArgsConstructor
@Component
public class MultiPartitionMessageProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String key, String payload) {
        log.info("Sending payload='{}' to topic='{}' with key='{}'", payload, topic, key);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key ,payload);
//        SuccessCallback<SendResult<String,String>> successCallback = sendResult -> {
//            if (sendResult != null)
//                log.info("Sent payload='{}' with key='{}' to topic-partition@offset='{}'", payload, key, sendResult.getRecordMetadata().toString());
//        };
//        FailureCallback failureCallback = throwable -> {
//            log.info("Sending payload='{}' to topic='{}' with key='{}' failed!!!", payload, topic, key);
//        };
//        future.addCallback(successCallback, failureCallback);
    }
}
