package com.praveen.rideshare.driver.dto;
import lombok.Data;

@Data
public class DriverRequest {
    private String name;
    private String vehicleType;
    private String licensePlate;
}

