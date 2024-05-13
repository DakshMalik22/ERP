package com.ERP.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Leaves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;

    private Date endDate;

    private String reason;

    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
