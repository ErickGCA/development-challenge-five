package com.example.medcloud.dto;

import com.example.medcloud.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String email;
    private Address address;
}