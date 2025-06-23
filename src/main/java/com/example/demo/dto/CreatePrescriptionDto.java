package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreatePrescriptionDto {
    private Integer patientId;
    private List<DrugQuantityDto> drugs;
}
