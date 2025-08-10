package com.praveen.rideshare.driver.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "drivers")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Driver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String vehicleType;
    private String licensePlate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        AVAILABLE, ON_TRIP, OFFLINE
    }

}
