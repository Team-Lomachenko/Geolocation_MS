package com.example.geolocation;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class PassengerGeolocation {

    @PrimaryKey
    private String passengerUsername;
    private String geolocation;

    public PassengerGeolocation(String passengerUsername, String geolocation) {
        this.passengerUsername = passengerUsername;
        this.geolocation = geolocation;
    }

    public String getPassengerUsername() {
        return passengerUsername;
    }

    public void setPassengerUsername(String passengerUsername) {
        this.passengerUsername = passengerUsername;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }
}
