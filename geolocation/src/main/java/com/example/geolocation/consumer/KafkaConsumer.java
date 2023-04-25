package com.example.geolocation.consumer;

import com.example.geolocation.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private PassengerGeolocationRepository passengerGeolocationRepository;
    private DriverGeolocationRepository driverGeolocationRepository;

    public KafkaConsumer(PassengerGeolocationRepository passengerGeolocationRepository, DriverGeolocationRepository driverGeolocationRepository) {
        this.passengerGeolocationRepository = passengerGeolocationRepository;
        this.driverGeolocationRepository = driverGeolocationRepository;
    }

    @KafkaListener(topics = {"passenger_geolocation", "driver_geolocation"}, groupId = "group_id")
    public void consume(ConsumerRecord<String, KafkaMessage> record) {
        String topic = record.topic();
        KafkaMessage message = record.value();
        String username = message.getUsername();
        String geolocation = message.getGeolocation();
        System.out.println("Received message from " + topic + ": " + username + geolocation);
        if (record.topic().equals("passenger_geolocation")) {
            PassengerGeolocation passengerGeolocation = new PassengerGeolocation(username, geolocation);
            passengerGeolocationRepository.save(passengerGeolocation);
        } else {
            DriverGeolocation driverGeolocation = new DriverGeolocation(username, geolocation);
            driverGeolocationRepository.save(driverGeolocation);
        }
    }
}
