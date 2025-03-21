package com.example.medcloud.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequest {
        @NotBlank(message = "Name is required.")
        @Size(min = 2, max = 100, message = "Name cannot be longer than 100 characters.")
        private String name;

        @NotNull(message = "Birthdate is required.")
        private LocalDate birthDate;

        @Email
        @NotBlank(message = "Email is required.")
        @Size(max = 255, message = "Email cannot be longer than 255 characters.")
        private String email;

        @Valid
        @NotNull(message = "Address is required.")
        private AddressRequest address;
}