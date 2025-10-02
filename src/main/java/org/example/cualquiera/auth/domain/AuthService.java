package org.example.cualquiera.auth.domain;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.cualquiera.auth.components.JwtService;
import org.example.cualquiera.auth.dtos.SignupDTO;
import org.example.cualquiera.auth.dtos.TokenResponse;
import org.example.cualquiera.user.domain.User;
import org.example.cualquiera.user.infrastructure.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public TokenResponse signUp(SignupDTO signupDTO){
        User user = userRepository.save(
                new User(
                        signupDTO.getEmail(),
                        passwordEncoder.encode(signupDTO.getPassword()),
                        signupDTO.getFirstName(),
                        signupDTO.getLastName()
                )
        );
        var token = jwtService.generateToken(user);
        return new TokenResponse(token);
    }

    public TokenResponse logIn(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                email,
                password
            )
        );
        var user = userRepository.findByEmail(email).orElseThrow();
        var token = jwtService.generateToken(user);
        return new TokenResponse(token);

    }

}
