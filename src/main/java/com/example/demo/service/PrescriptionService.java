package com.example.demo.service;

import com.example.demo.dto.CreatePrescriptionDto;
import com.example.demo.dto.DrugQuantityDto;
import com.example.demo.model.Drug;
import com.example.demo.model.Prescription;
import com.example.demo.model.PrescriptionDrug;
import com.example.demo.repository.DrugRepository;
import com.example.demo.repository.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PrescriptionService {
    PrescriptionRepository prescriptionRepository;
    DrugRepository drugRepository;

    public Prescription createPrescription(CreatePrescriptionDto createPrescriptionDto) {
        Prescription prescription = new Prescription();
        prescription.setPatientId(createPrescriptionDto.getPatientId());

        List<PrescriptionDrug> prescriptionDrugs = new ArrayList<>();

        for (DrugQuantityDto drugDto : createPrescriptionDto.getDrugs()) {
            Drug drug = drugRepository.findById(drugDto.getDrugId()).orElse(null);

            PrescriptionDrug prescriptionDrug = new PrescriptionDrug();
            prescriptionDrug.setDrug(drug);
            prescriptionDrug.setQuantity(drugDto.getQuantity());
            prescriptionDrug.setPrescription(prescription);

            prescriptionDrugs.add(prescriptionDrug);
        }

        prescription.setDrugs(prescriptionDrugs);
        return prescriptionRepository.save(prescription);
    }

    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    public void deletePrescriptionById(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
