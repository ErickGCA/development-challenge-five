package com.example.medcloud.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequest {
        @NotBlank
        private String name;

        @NotNull
        private LocalDate birthDate;

        @Email
        @NotBlank
        private String email;

        @Valid
        @NotNull
        private AddressRequest address;
}