package com.example.geolocation;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PassengerGeolocationRepository extends CassandraRepository<PassengerGeolocation, String> {
}
