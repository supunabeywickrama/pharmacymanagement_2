package com.example.demo.dto;

import lombok.Data;

@Data
public class CreateDrugDto {
    private String name;
    private Double unitPrice;
    private Integer quantity;
}
