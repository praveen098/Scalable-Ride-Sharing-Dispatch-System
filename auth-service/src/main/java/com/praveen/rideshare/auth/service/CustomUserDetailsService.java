package com.praveen.rideshare.auth.security;

import com.praveen.rideshare.auth.domain.User;
import com.praveen.rideshare.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + username));

        // Convert your User entity into Spring Security’s UserDetails
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                // strip the "ROLE_" prefix, since .roles() will add it back
                .roles(user.getRole().replaceFirst("^ROLE_", ""))
                .build();
    }
}
