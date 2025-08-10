// controller/DriverController.java
package com.praveen.rideshare.driver.controller;

import com.praveen.rideshare.driver.dto.*;
import com.praveen.rideshare.driver.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService svc;

    @PostMapping
    public ResponseEntity<DriverResponse> create(@RequestBody DriverRequest req) {
        return ResponseEntity.ok(svc.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(svc.get(id));
    }

    @GetMapping
    public ResponseEntity<List<DriverResponse>> list() {
        return ResponseEntity.ok(svc.list());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverResponse> update(@PathVariable Long id,
                                                 @RequestBody DriverRequest req) {
        return ResponseEntity.ok(svc.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
