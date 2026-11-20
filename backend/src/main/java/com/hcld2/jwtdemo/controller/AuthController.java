package com.hcld2.jwtdemo.controller;

import com.hcld2.jwtdemo.dto.AuthRequest;
import com.hcld2.jwtdemo.dto.AuthResponse;
import com.hcld2.jwtdemo.dto.StatusResponse;
import com.hcld2.jwtdemo.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<StatusResponse> register(@Valid @RequestBody AuthRequest req) {
        StatusResponse result = authService.registerUser(req);
        if ("error".equals(result.type())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest req) {
        AuthResponse result = authService.login(req);
        if ("error".equals(result.token())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        }
        return ResponseEntity.ok(result);
    }
}