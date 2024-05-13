package com.ERP.services;

import com.ERP.entities.SalaryStructure;
import com.ERP.exceptions.SalaryStructureNotFoundException;
import com.ERP.repositories.SalaryStructureRepository;
import com.ERP.servicesInter.SalaryStructureServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SalaryStructureService implements SalaryStructureServiceInter {
    @Autowired
    private SalaryStructureRepository salaryStructureRepository;

    @Override
    public List<SalaryStructure> fetchSalaryStructureList() {
        return salaryStructureRepository.findAll();
    }

    @Override
    public SalaryStructure fetchSalaryStructureById(int structureId) throws SalaryStructureNotFoundException{
        Optional<SalaryStructure> salaryStructure = salaryStructureRepository.findById(structureId);
        if(!salaryStructure.isPresent()){
            throw new SalaryStructureNotFoundException("SalaryStructure Not Available");
        }
        return salaryStructure.get();
    }

    @Override
    public SalaryStructure addSalaryStructure(SalaryStructure salaryStructure) {
        return salaryStructureRepository.save(salaryStructure);
    }

    @Override
    public List<SalaryStructure> fetchSalaryStructureByRole(String role) throws SalaryStructureNotFoundException {
        return salaryStructureRepository.findAllByRole(role);
    }

    @Override
    public void removeSalaryStructure(int structureId){
        salaryStructureRepository.deleteById(structureId);
    }

    public SalaryStructure updateSalaryStructure(int structureId, SalaryStructure salaryStructure){
        SalaryStructure salaryStructure1 = salaryStructureRepository.findById(structureId).get();

        if(Objects.nonNull(salaryStructure.getRole()) &&
                !"".equalsIgnoreCase(salaryStructure.getRole())){
            salaryStructure1.setRole(salaryStructure.getRole());
        }

        if(Objects.nonNull(salaryStructure.getLevel()) &&
                !"".equalsIgnoreCase(salaryStructure.getLevel())){
            salaryStructure1.setLevel(salaryStructure.getLevel());
        }

        if(Objects.nonNull(salaryStructure.getBaseSalary()) &&
                salaryStructure.getBaseSalary() != 0.0){
            salaryStructure1.setBaseSalary(salaryStructure.getBaseSalary());
        }
        return salaryStructureRepository.save(salaryStructure1);
    }
}
