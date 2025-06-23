package com.example.demo.service;


import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public List<Patient> getAllPatients() {
        return repo.findAll();
    }

    public Optional<Patient> getPatientById(Integer doctorId) {
        return repo.findById(doctorId);
    }

    public Patient savePatient(Patient patient) {
        return repo.save(patient);
    }

    public void deletePatient(Integer doctorId) {
        repo.deleteById(doctorId);
    }
}
