package com.example.demo.service;

import com.example.demo.dto.DrugQuantityDto;
import com.example.demo.dto.InvoiceResponseDto;
import com.example.demo.model.Drug;
import com.example.demo.model.Invoice;
import com.example.demo.model.Prescription;
import com.example.demo.model.PrescriptionDrug;
import com.example.demo.repository.DrugRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceService {
    private InvoiceRepository invoiceRepository;
    private PrescriptionRepository prescriptionRepository;
    private DrugRepository drugRepository;

    public InvoiceResponseDto createInvoice(Integer prescriptionId){
        Prescription prescription = prescriptionRepository.findById(prescriptionId).orElse(null);
        //List<DrugQuantityDto> drugQuantity = new ArrayList<>();
        Double totalAmount = 0.0;
        for (PrescriptionDrug drugQuantity : prescription.getPrescriptionDrugs()){
            Drug drug = drugQuantity.getDrug();
            Integer amount = drugQuantity.getQuantity();
            Double unitPrice = drug.getUnitPrice();
            Double totalPrice = amount * unitPrice;
            totalAmount += totalPrice;
        }
        Invoice invoice = new Invoice();
        //invoice.setPrescriptionId(prescriptionId);
        invoice.setPatientId(prescription.getPatientId());
        invoice.setTotalAmount(totalAmount);
        invoice.setPrescription(prescription);
        invoiceRepository.save(invoice);

        return new InvoiceResponseDto(
                invoice.getInvoiceId(),
                invoice.getPatientId(),
                invoice.getTotalAmount(),
                prescription.getPrescriptionDrugs()

        );
    }
}



//prescription.getDrugs().stream()
//                .map(drug -> new DrugQuantityDto(drug.getDrug().getId(), drug.getQuantity()))
//        .toList();
