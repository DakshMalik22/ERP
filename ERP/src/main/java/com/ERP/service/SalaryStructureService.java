package com.ERP.service;

import com.ERP.entity.SalaryStructure;
import com.ERP.error.SalaryStructureNotFoundException;

import java.util.List;

public interface SalaryStructureService {
    public List<SalaryStructure> fetchSalaryStructureList();
    public SalaryStructure fetchSalaryStructureById(int structureId) throws SalaryStructureNotFoundException;
    public SalaryStructure addSalaryStructure(SalaryStructure salaryStructure);
    public List<SalaryStructure> fetchSalaryStructureByRole(String role) throws SalaryStructureNotFoundException;
    public void removeSalaryStructure(int structureId);
    public SalaryStructure updateSalaryStructure(int structureId, SalaryStructure salaryStructure);
}
