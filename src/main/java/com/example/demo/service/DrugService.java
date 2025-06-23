package com.example.demo.service;

import com.example.demo.dto.CreateDrugDto;
import com.example.demo.model.Drug;
import com.example.demo.repository.DrugRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DrugService {
    private DrugRepository drugRepository;

    public Drug saveDrug(CreateDrugDto createDrugDto) {
        Drug drug = new Drug();
        drug.setName(createDrugDto.getName());
        drug.setQuantity(createDrugDto.getQuantity());
        drug.setUnitPrice(createDrugDto.getUnitPrice());
        return drugRepository.save(drug);
    }

    public void deleteDrug(Integer drugId) {
        drugRepository.deleteById(drugId);
    }

    public Drug getDrugById(Integer drugId) {
        Drug drug = drugRepository.findById(drugId).orElse(null);
        return drug;
    }

    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    public void updateDrug(Integer drugId, CreateDrugDto createDrugDto)  {
        Drug drug =  drugRepository.findById(drugId).orElse(null);

        if(createDrugDto.getName() != null){
            drug.setName(createDrugDto.getName());
        }
        if (createDrugDto.getQuantity() != null) {
            drug.setQuantity(createDrugDto.getQuantity());
        }
        if (createDrugDto.getUnitPrice() != null) {
            drug.setUnitPrice(createDrugDto.getUnitPrice());
        }
        drugRepository.save(drug);
    }
}
