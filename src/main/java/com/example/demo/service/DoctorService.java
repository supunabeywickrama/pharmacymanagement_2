package com.example.demo.service;


import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repo;

    public List<Doctor> getAllDoctors() {
        return repo.findAll();
    }

    public Optional<Doctor> getDoctorById(Integer doctorId) {
        return repo.findById(doctorId);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return repo.save(doctor);
    }

    public void deleteDoctor(Integer doctorId) {
        repo.deleteById(doctorId);
    }
}
