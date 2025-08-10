package com.praveen.rideshare.rider.dto;

import lombok.Data;

@Data
public class RiderResponse {
    Long id;
    String name;
    String paymentMethod;
}
