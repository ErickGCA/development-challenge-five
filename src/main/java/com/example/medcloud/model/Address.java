package com.example.medcloud.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.*;

@Embeddable
@Getter
@Setter
public class Address {


    private String street;
    private String city;
    private String state;
    private String number;
    private String postalCode;
}
