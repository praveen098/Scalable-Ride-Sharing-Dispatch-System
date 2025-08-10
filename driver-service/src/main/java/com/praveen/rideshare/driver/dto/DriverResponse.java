package com.praveen.rideshare.driver.dto;

import lombok.Data;

@Data
public class DriverResponse {
    private Long id;
    private String name;
    private String vehicleType;
    private String licensePlate;
    private String status;
}
