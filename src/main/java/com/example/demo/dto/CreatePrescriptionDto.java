package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreatePrescriptionDto {
    private Long patientId;
    private List<DrugQuantityDto> drugs;
}
