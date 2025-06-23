package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;

    private Integer patientId;
    private Double totalAmount;

    @OneToOne
    @JoinColumn(name = "prescription_id", referencedColumnName = "prescriptionId")
    private Prescription prescription;
}








//package com.example.demo.model;
//
//import com.example.demo.dto.DrugQuantityDto;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Entity
//@Data
//public class Invoice {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer invoiceId;
//    //private Integer prescriptionId;
//    private Integer patientId;
//    private Double totalAmount;
//    @OneToOne
//   // @JoinColumn(name = "prescription_id")
//    private Prescription prescription;
//
//}
