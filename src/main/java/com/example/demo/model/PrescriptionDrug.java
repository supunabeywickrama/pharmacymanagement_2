package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PrescriptionDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer



            id;
    @ManyToOne
    @JoinColumn(name = "prescription_Id")
    @JsonBackReference
    private Prescription prescription;
    @ManyToOne
    @JoinColumn(name = "drug_Id")
    @JsonManagedReference
    private Drug drug;
    private Integer quantity;
}
