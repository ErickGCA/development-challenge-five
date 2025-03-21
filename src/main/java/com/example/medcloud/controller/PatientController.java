package com.example.medcloud.controller;

import com.example.medcloud.dto.PatientRequest;
import com.example.medcloud.dto.PatientResponse;
import com.example.medcloud.service.PatientService;
import com.example.medcloud.config.SecurityConfig;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final SecurityConfig securityConfig;

    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(
            @RequestHeader("X-API-KEY") String apiKey,
            @Valid @RequestBody PatientRequest request) {

        securityConfig.validateApiKey(apiKey);
        return ResponseEntity.ok(patientService.createPatient(request));
    }

    @GetMapping
    public ResponseEntity<PatientResponse> getPatientByEmail(
            @RequestHeader("X-API-KEY") String apiKey,
            @RequestParam String email) {

        securityConfig.validateApiKey(apiKey);
        return ResponseEntity.ok(patientService.getPatientByEmail(email));
    }
}