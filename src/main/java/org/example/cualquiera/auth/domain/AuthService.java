package org.example.cualquiera.auth.domain;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.cualquiera.auth.components.JwtService;
import org.example.cualquiera.user.infrastructure.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
}
