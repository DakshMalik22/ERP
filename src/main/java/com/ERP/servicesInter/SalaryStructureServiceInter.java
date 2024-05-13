package com.ERP.servicesInter;

import com.ERP.entities.SalaryStructure;
import com.ERP.exceptions.SalaryStructureNotFoundException;

import java.util.List;

public interface SalaryStructureServiceInter {
    public List<SalaryStructure> fetchSalaryStructureList();
    public SalaryStructure fetchSalaryStructureById(int structureId) throws SalaryStructureNotFoundException;
    public SalaryStructure addSalaryStructure(SalaryStructure salaryStructure);
    public List<SalaryStructure> fetchSalaryStructureByRole(String role) throws SalaryStructureNotFoundException;
    public void removeSalaryStructure(int structureId);
    public SalaryStructure updateSalaryStructure(int structureId, SalaryStructure salaryStructure);
}
