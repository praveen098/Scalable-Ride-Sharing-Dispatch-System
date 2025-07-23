package com.praveen.rideshare.auth.service;

import com.praveen.rideshare.auth.domain.User;
import com.praveen.rideshare.auth.repository.UserRepository;
import com.praveen.rideshare.auth.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;

    public String signup(String username, String password) {
        if (userRepo.existsByUsername(username)) {
            throw new IllegalArgumentException("Username taken");
        }
        User u = User.builder()
                .username(username)
                .password(encoder.encode(password))
                .build();
        userRepo.save(u);
        return jwtProvider.generateToken(username);
    }

    public String login(String username, String password) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }
        return jwtProvider.generateToken(username);
    }
}
