package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer drugId;
    private String name;
    private Double unitPrice;
    private Integer quantity;
    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<PrescriptionDrug> prescriptionDrugs;
}
