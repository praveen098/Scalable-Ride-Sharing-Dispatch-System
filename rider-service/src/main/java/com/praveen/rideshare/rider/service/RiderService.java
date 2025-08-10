// rider-service/src/main/java/com/praveen/rideshare/rider/service/RiderService.java
package com.praveen.rideshare.rider.service;

import com.praveen.rideshare.rider.domain.Rider;
import com.praveen.rideshare.rider.dto.RiderRequest;
import com.praveen.rideshare.rider.dto.RiderResponse;
import com.praveen.rideshare.rider.repository.RiderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RiderService {
    private final RiderRepository repo;

    public RiderResponse create(RiderRequest req) {
        Rider r = Rider.builder()
                .name(req.getName())
                .paymentMethod(req.getPaymentMethod())
                .build();
        r = repo.save(r);
        return toDto(r);
    }

    public RiderResponse get(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Rider not found"));
    }

    public List<RiderResponse> list() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public RiderResponse update(Long id, RiderRequest req) {
        Rider r = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rider not found"));
        r.setName(req.getName());
        r.setPaymentMethod(req.getPaymentMethod());
        r = repo.save(r);
        return toDto(r);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private RiderResponse toDto(Rider r) {
        RiderResponse dto = new RiderResponse();
        dto.setId(r.getId());
        dto.setName(r.getName());
        dto.setPaymentMethod(r.getPaymentMethod());
        return dto;
    }
}

