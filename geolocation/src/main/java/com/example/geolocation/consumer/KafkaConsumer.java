package com.example.geolocation.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "geolocation", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
