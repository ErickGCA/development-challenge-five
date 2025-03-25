package com.example.medcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.medcloud.dto.PatientRequest;
import com.example.medcloud.dto.PatientResponse;
import com.example.medcloud.service.PatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@Tag(name = "Patients", description = "Patient management operations")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    @Operation(
        summary = "Create Patient", 
        description = "Create a new patient record",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "Patient successfully created",
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = PatientResponse.class)
                )
            ),
            @ApiResponse(
                responseCode = "400", 
                description = "Invalid patient data",
                content = @Content(mediaType = "application/json")
            )
        }
    )
    public ResponseEntity<PatientResponse> createPatient(
        @Valid @RequestBody PatientRequest request
    ) {
        return ResponseEntity.ok(patientService.createPatient(request));
    }

    @GetMapping
    @Operation(
        summary = "Get Patient by Email", 
        description = "Retrieve patient information by email",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "Patient found",
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = PatientResponse.class)
                )
            ),
            @ApiResponse(
                responseCode = "404", 
                description = "Patient not found",
                content = @Content(mediaType = "application/json")
            )
        }
    )
    public ResponseEntity<PatientResponse> getPatientByEmail(
        @Parameter(description = "Patient's email address", required = true)
        @RequestParam String email
    ) {
        return ResponseEntity.ok(patientService.getPatientByEmail(email));
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Update Patient", 
        description = "Update an existing patient record",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "Patient successfully updated",
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = PatientResponse.class)
                )
            ),
            @ApiResponse(
                responseCode = "404", 
                description = "Patient not found",
                content = @Content(mediaType = "application/json")
            )
        }
    )
    public ResponseEntity<PatientResponse> updatePatient(
        @Parameter(description = "Patient ID", required = true)
        @PathVariable Long id,
        @Valid @RequestBody PatientRequest request
    ) {
        return ResponseEntity.ok(patientService.updatePatient(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Delete Patient", 
        description = "Delete a patient record",
        responses = {
            @ApiResponse(
                responseCode = "204", 
                description = "Patient successfully deleted"
            ),
            @ApiResponse(
                responseCode = "404", 
                description = "Patient not found",
                content = @Content(mediaType = "application/json")
            )
        }
    )
    public ResponseEntity<Void> deletePatient(
        @Parameter(description = "Patient ID", required = true)
        @PathVariable Long id
    ) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}