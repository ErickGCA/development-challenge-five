package com.example.medcloud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
        @NotBlank
        private String street;

        @NotBlank
        private String city;

        @NotBlank
        private String state;

        @NotBlank
        private String zipCode;
}