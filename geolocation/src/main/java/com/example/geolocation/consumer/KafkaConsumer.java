package com.example.geolocation.consumer;

import com.example.geolocation.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class KafkaConsumer {
    private PassengerGeolocationRepository passengerGeolocationRepository;
    private DriverGeolocationRepository driverGeolocationRepository;

    public KafkaConsumer(PassengerGeolocationRepository passengerGeolocationRepository, DriverGeolocationRepository driverGeolocationRepository) {
        this.passengerGeolocationRepository = passengerGeolocationRepository;
        this.driverGeolocationRepository = driverGeolocationRepository;
    }

    @KafkaListener(topics = "passenger_geolocation", groupId = "group_id")
    public void consumePassenger(HashMap<String, String> message) {
        String username = message.get("username");
        String geolocation = message.get("geolocation");
        System.out.println("Received message from: " + username + geolocation);
        PassengerGeolocation passengerGeolocation = new PassengerGeolocation(username, geolocation);
        passengerGeolocationRepository.save(passengerGeolocation);
    }

    @KafkaListener(topics = "driver_geolocation", groupId = "group_id")
    public void consumeDriver(HashMap<String, String> message) {
        String username = message.get("username");
        String geolocation = message.get("geolocation");
        System.out.println("Received message from: " + username + geolocation);
        DriverGeolocation driverGeolocation = new DriverGeolocation(username, geolocation);
        driverGeolocationRepository.save(driverGeolocation);
    }
}
