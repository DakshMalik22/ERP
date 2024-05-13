package com.ERP.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="client")
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;
    @Column
    private String name;
    private String email;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    Set<Project> projectSet = new HashSet<>();
}