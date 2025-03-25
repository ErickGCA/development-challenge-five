package com.example.medcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medcloud.dto.AuthRequest;
import com.example.medcloud.dto.AuthResponse;
import com.example.medcloud.model.User;
import com.example.medcloud.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "User authentication and registration endpoints")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @Operation(
        summary = "User Login", 
        description = "Authenticate user and generate JWT token",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "Successfully authenticated",
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = AuthResponse.class)
                )
            ),
            @ApiResponse(
                responseCode = "401", 
                description = "Authentication failed",
                content = @Content(mediaType = "application/json")
            )
        }
    )
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.login(authRequest));
    }
    
    @PostMapping("/register")
    @Operation(
        summary = "User Registration", 
        description = "Register a new user in the system",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "User successfully registered",
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = User.class)
                )
            ),
            @ApiResponse(
                responseCode = "400", 
                description = "Registration failed",
                content = @Content(mediaType = "application/json")
            )
        }
    )
    public ResponseEntity<User> register(@RequestBody AuthRequest request) {
        User user = authService.registerUser(request.getUsername(), request.getPassword(), "ROLE_USER");
        
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }
}