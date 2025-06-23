package com.example.demo.repository;

import com.example.demo.model.PrescriptionDrug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionDrugRepository extends JpaRepository<PrescriptionDrug, Long> {
}
