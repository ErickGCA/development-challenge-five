package com.example.medcloud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
        @NotBlank(message = "Street is required. ")
        @Size(max = 100, message = "Street cannot be longer than 100 characters.")
        private String street;

        @NotBlank(message = "City is required. ")
        @Size(max = 100, message = "City cannot be longer than 100 characters")
        private String city;

        @NotBlank (message = "State is required. ")
        @Size(max = 100, message = "State cannot be longer than 100 characters")
        private String state;

        @NotBlank(message = "zipCode is required . ")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "Invalid ZipCode format. It should be in the format 12345-123.")
        private String zipCode;
}