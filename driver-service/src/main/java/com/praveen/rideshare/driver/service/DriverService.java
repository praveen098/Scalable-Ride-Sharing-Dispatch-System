package com.praveen.rideshare.driver.service;

import com.praveen.rideshare.driver.domain.Driver;
import com.praveen.rideshare.driver.dto.DriverRequest;
import com.praveen.rideshare.driver.dto.DriverResponse;
import com.praveen.rideshare.driver.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository repo;

    public DriverResponse create(DriverRequest req){
        Driver d = Driver.builder()
                .name(req.getName())
                .vehicleType(req.getVehicleType())
                .licensePlate((req.getLicensePlate()))
                .status(Driver.Status.AVAILABLE)
                .build();
        d = repo.save(d);
        return toDto(d);
    }

    public DriverResponse get(Long id){
        return repo.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Driver not found"));
    }
    public List<DriverResponse> list() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    public DriverResponse update(Long id, DriverRequest req) {
        Driver d = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Driver not found"));
        d.setName(req.getName());
        d.setVehicleType(req.getVehicleType());
        d.setLicensePlate(req.getLicensePlate());
        d = repo.save(d);
        return toDto(d);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    private DriverResponse toDto(Driver d) {
        DriverResponse r = new DriverResponse();
        r.setId(d.getId());
        r.setName(d.getName());
        r.setVehicleType(d.getVehicleType());
        r.setLicensePlate(d.getLicensePlate());
        r.setStatus(d.getStatus().name());
        return r;
    }
}
