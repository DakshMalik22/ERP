package com.ERP.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "salary_structure_table", uniqueConstraints = @UniqueConstraint(
        name = "structure_id_unique",
        columnNames = "structure_id"
))
public class SalaryStructure {
    @Id
    @SequenceGenerator(
            name = "salary_structure_sequence", // Specify the name of sequence generator
            sequenceName = "salary_structure_sequence_name", // Specify the name of your sequence in the db
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "salary_structure_sequence"
    )
    private int structureId;

    private String role;
    private String level;
    private double baseSalary;

    public void setId(int i) {
    }
}
