package com.phucle.kafkaproducer.controller;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

import static com.phucle.kafkaproducer.config.KafkaTopicConfig.SIMPLE_MESSAGE_TOPIC;
import static com.phucle.kafkaproducer.config.KafkaTopicConfig.STREAM_RAW_DATA_TOPIC;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class KafkaExampleController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final StreamsBuilderFactoryBean factoryBean;

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.OK)
    void sendSimpleMessage(@RequestBody Map<String, String> message) {
        kafkaTemplate.send(SIMPLE_MESSAGE_TOPIC, message.get("message"));
    }

    @PostMapping("/stream")
    @ResponseStatus(HttpStatus.OK)
    void sendSimpleSearchKeyword(@RequestBody Map<String, String> message) {
        kafkaTemplate.send(STREAM_RAW_DATA_TOPIC, message.get("keyword"));
    }

    @GetMapping("/count/{word}")
    public Map<String, Long> getWordCount(@PathVariable String word) {
        KafkaStreams kafkaStreams = factoryBean.getKafkaStreams();
        ReadOnlyKeyValueStore<String, Long> counts = kafkaStreams.store(
                StoreQueryParameters.fromNameAndType("counts", QueryableStoreTypes.keyValueStore())
        );
        return Collections.singletonMap(word, counts.get(word));
    }
}
