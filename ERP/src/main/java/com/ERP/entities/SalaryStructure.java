package com.ERP.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "salary_structure")
public class SalaryStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long structureId;

    private String role;
    private String level;
    private double baseSalary;
}
