package com.Application.HospitalManagementSys.Entity.DocLogin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "stock")
    private Integer  stock;

    public Medicine(String drugName, Integer stock) {
        this.drugName = drugName;
        this.stock = stock;
    }
}
