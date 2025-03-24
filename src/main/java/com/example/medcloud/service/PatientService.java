package com.example.medcloud.service;

import com.example.medcloud.dto.PatientRequest;
import com.example.medcloud.dto.PatientResponse;
import com.example.medcloud.model.Address;
import com.example.medcloud.model.Patient;
import com.example.medcloud.exception.PatientNotFoundException;

import com.example.medcloud.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientResponse createPatient(PatientRequest request) {
        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setBirthDate(request.getBirthDate());
        patient.setEmail(request.getEmail());

        Address address = new Address();
        address.setStreet(request.getAddress().getStreet());
        address.setCity(request.getAddress().getCity());
        address.setState(request.getAddress().getState());
        address.setZipCode(request.getAddress().getZipCode());

        patient.setAddress(address);

        return mapToResponse(patientRepository.save(patient));
    }

    public PatientResponse getPatientByEmail(String email) {
        return patientRepository.findByEmail(email)
                .map(this::mapToResponse)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with email: " + email));
    }

    private PatientResponse mapToResponse(Patient patient) {
        PatientResponse response = new PatientResponse();
        response.setName(patient.getName());
        response.setBirthDate(patient.getBirthDate());
        response.setEmail(patient.getEmail());
        response.setAddress(patient.getAddress());
        return response;
    }
    public PatientResponse updatePatient(Long id, PatientRequest request) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
    
        patient.setName(request.getName());
        patient.setBirthDate(request.getBirthDate());
        patient.setEmail(request.getEmail());
    
        Address address = new Address();
        address.setStreet(request.getAddress().getStreet());
        address.setCity(request.getAddress().getCity());
        address.setState(request.getAddress().getState());
        address.setZipCode(request.getAddress().getZipCode());
    
        patient.setAddress(address);
    
        return mapToResponse(patientRepository.save(patient));
    }
    
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
        patientRepository.delete(patient);
    }
    
}