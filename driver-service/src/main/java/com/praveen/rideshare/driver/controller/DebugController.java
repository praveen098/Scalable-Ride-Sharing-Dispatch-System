package com.praveen.rideshare.driver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    @Value("${jwt.secret:<<missing>>}")
    private String secret;

    @GetMapping("/debug/secret")
    public String loadedSecret() {
        // we return only the length so you don’t leak it verbatim
        if (secret == null) return "secret==null";
        return "secret.length=" + secret.length();
    }
}
