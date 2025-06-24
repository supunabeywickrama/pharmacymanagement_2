package com.example.demo.controller;

import com.example.demo.dto.InvoiceResponseDto;
import com.example.demo.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;

    @PostMapping("/invoices/{prescriptionId}")
    public InvoiceResponseDto createInvoice(@PathVariable Integer prescriptionId){
        return invoiceService.createInvoice(prescriptionId);
    }
}
