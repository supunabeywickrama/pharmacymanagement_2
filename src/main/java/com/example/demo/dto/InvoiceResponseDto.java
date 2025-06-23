package com.example.demo.dto;

import com.example.demo.model.Drug;
import com.example.demo.model.PrescriptionDrug;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InvoiceResponseDto {
    private Integer invoiceId;
    private Integer patientId;
    private List<PrescriptionDrug> drugs;
    private Double totalAmount;

}
