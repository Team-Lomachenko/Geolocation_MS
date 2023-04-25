package com.example.geolocation;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class DriverGeolocation {

    @PrimaryKey
    private String driverUsername;
    private String geolocation;

    public DriverGeolocation(String driverUsername, String geolocation) {
        this.driverUsername = driverUsername;
        this.geolocation = geolocation;
    }

    public String getDriverUsername() {
        return driverUsername;
    }

    public void setDriverUsername(String driverUsername) {
        this.driverUsername = driverUsername;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }
}
