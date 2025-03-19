        package com.example.medcloud.dto;

        import jakarta.validation.constraints.NotBlank;
        import jakarta.validation.constraints.Size;

        public record AddressDTO(
                @NotBlank(message = "Street is mandatory")
                String street,

                @NotBlank(message = "Number is mandatory")
                String number,

                @NotBlank(message = "City is mandatory")
                String city,

                @NotBlank(message = "State is mandatory")
                @Size(min = 2, max = 2, message = "State must have 2 characters")
                String state
        ) {}
