package com.ERP.repository;

import com.ERP.entity.SalaryStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryStructureRepository extends JpaRepository<SalaryStructure, Integer> {
    public List<SalaryStructure> findAllByRole(String role);
}
