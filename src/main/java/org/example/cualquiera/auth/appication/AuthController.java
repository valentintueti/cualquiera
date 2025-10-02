package org.example.cualquiera.auth.appication;

import lombok.RequiredArgsConstructor;
import org.example.cualquiera.auth.domain.AuthService;
import org.example.cualquiera.auth.dtos.SignupDTO;
import org.example.cualquiera.auth.dtos.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<TokenResponse> signUp(@RequestBody SignupDTO signupDTO) {
        return ResponseEntity.ok(authService.signUp(signupDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> logIn(@RequestBody SignupDTO loginDTO) {
        return ResponseEntity.ok(authService.logIn(loginDTO.getEmail(), loginDTO.getPassword()));
    }

}
