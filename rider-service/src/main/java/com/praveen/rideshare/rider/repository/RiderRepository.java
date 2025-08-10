package com.praveen.rideshare.rider.repository;

import com.praveen.rideshare.rider.domain.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider,Long> { }

