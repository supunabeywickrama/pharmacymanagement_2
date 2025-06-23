package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prescriptionId;
    private Integer patientId;
    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PrescriptionDrug> drugs;
    @OneToOne(mappedBy = "prescription")
    private Invoice invoice;
}
