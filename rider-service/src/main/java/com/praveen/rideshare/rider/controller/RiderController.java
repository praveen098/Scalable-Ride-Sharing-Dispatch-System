// rider-service/src/main/java/com/praveen/rideshare/rider/controller/RiderController.java
package com.praveen.rideshare.rider.controller;

import com.praveen.rideshare.rider.dto.RiderRequest;
import com.praveen.rideshare.rider.dto.RiderResponse;
import com.praveen.rideshare.rider.service.RiderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/riders")
@RequiredArgsConstructor
public class RiderController {

    private final RiderService svc;

    @PostMapping
    public ResponseEntity<RiderResponse> create(@RequestBody @Valid RiderRequest r) {
        return ResponseEntity.ok(svc.create(r));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiderResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(svc.get(id));
    }

    @GetMapping
    public ResponseEntity<List<RiderResponse>> list() {
        return ResponseEntity.ok(svc.list());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiderResponse> update(@PathVariable Long id,
                                                @RequestBody @Valid RiderRequest r) {
        return ResponseEntity.ok(svc.update(id, r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
