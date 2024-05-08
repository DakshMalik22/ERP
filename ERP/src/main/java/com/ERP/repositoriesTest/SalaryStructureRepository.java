package com.ERP.repositoriesTest;

import com.ERP.entitiesTest.SalaryStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryStructureRepository extends JpaRepository<SalaryStructure, Integer> {
    public List<SalaryStructure> findAllByRole(String role);
}
