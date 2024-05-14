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
@Table(name = "hr")
public class HR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hrId;

    private String name;
    private String password;
    private String role;
}
