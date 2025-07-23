package com.praveen.rideshare.auth.controller;

import com.praveen.rideshare.auth.dto.AuthResponse;
import com.praveen.rideshare.auth.dto.LoginRequest;
import com.praveen.rideshare.auth.dto.SignupRequest;
import com.praveen.rideshare.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req) {
        String token = authService.signup(req.getUsername(), req.getPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        try {
            String token = authService.login(req.getUsername(), req.getPassword());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException ex) {
            // either bad credentials or lookup error
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid username or password"));
        }
    }
}
