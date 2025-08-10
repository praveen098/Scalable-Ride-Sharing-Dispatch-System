package com.praveen.rideshare.dispatch.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dispatch")
public class DisptachController {
    @GetMapping
    public List<String> test() {
        return List.of("dispatch‑1", "dispatch‑2");
    }
}

