package com.praveen.rideshare.rider.dto;

import lombok.Data;



public class RiderRequest {
    private String name;
    private String paymentMethod;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}




