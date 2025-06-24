package com.example.demo.dto;

import com.example.demo.model.PrescriptionDrug;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PrescriptionResponseDto {
    private Integer prescriptionId;
    private Integer patientId;
    private List <DrugQuantityDto> drugs;
}
