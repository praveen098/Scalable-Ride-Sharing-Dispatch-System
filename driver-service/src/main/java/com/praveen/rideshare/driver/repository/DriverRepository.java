package com.praveen.rideshare.driver.repository;


import com.praveen.rideshare.driver.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Long>{

}
