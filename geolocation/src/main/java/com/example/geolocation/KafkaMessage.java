package com.example.geolocation;

public class KafkaMessage {
    private String username;
    private String geolocation;

    public KafkaMessage(String username, String geolocation) {
        this.username = username;
        this.geolocation = geolocation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }
}
