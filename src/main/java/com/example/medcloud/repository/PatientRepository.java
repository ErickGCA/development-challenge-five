package com.example.medcloud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medcloud.model.Patient; // Corrigido o caminho da importação

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
}