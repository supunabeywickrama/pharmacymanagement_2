package com.example.demo.controller;

import com.example.demo.dto.CreateDrugDto;
import com.example.demo.model.Drug;
import com.example.demo.service.DrugService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DrugController {
    private DrugService drugService;

    @PostMapping("drugs")
    public Drug saveDrug (@RequestBody CreateDrugDto createDrugDto){
        return drugService.saveDrug(createDrugDto);
    }

    @DeleteMapping("/drugs/{drugId}")
    public void deleteDrug(@PathVariable Integer drugId){
        drugService.deleteDrug(drugId);
    }

    @GetMapping("/drugs/{drugId}")
    public Drug getDrugById(@PathVariable Integer drugId){
        return drugService.getDrugById(drugId);
    }

    @GetMapping("/drugs")
    public List<Drug> getAllDrugs(){
        return drugService.getAllDrugs();
    }

    @PutMapping("/drugs/{drugId}")
    public void updateDrug(@PathVariable Integer drugId,@RequestBody CreateDrugDto createDrugDto){
        drugService.updateDrug(drugId,createDrugDto);
    }

}
