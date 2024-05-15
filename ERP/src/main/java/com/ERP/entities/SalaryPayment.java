package com.ERP.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="salary_payment")
public class SalaryPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private double amount;

    @Temporal(TemporalType.DATE)
    @Column(name = "payment_date")
    private Date paymentDate;
}
