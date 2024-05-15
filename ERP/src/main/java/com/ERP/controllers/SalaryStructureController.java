package com.ERP.controllers;

import com.ERP.entities.SalaryStructure;
import com.ERP.exceptions.SalaryStructureNotFoundException;
import com.ERP.servicesInter.SalaryStructureServiceInter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryStructureController {
    @Autowired
    private SalaryStructureServiceInter salaryStructureService;

    @GetMapping("/salaryStructure")
    public List<SalaryStructure> getSalaryStructure(){
        return salaryStructureService.fetchSalaryStructureList();
    }

    @PostMapping("/addSalaryStructure")
    public SalaryStructure addSalaryStructure(@Valid @RequestBody SalaryStructure salaryStructure){
        return salaryStructureService.addSalaryStructure(salaryStructure);
    }

    @GetMapping("/salaryStructure/{id}")
    public SalaryStructure getSalaryStructureById(@PathVariable("id") int structureId) throws SalaryStructureNotFoundException {
        return salaryStructureService.fetchSalaryStructureById(structureId);
    }

    @GetMapping("/salaryStructure/role/{role}")
    public List<SalaryStructure> fetchSalaryStructureByRole(@PathVariable("role") String role) throws SalaryStructureNotFoundException {
        return salaryStructureService.fetchSalaryStructureByRole(role);
    }

    @DeleteMapping("/removeSalaryStructure/{id}")
    public void removeSalaryStructure(@PathVariable("id") int structureId){
        salaryStructureService.removeSalaryStructure(structureId);
    }

    @PutMapping("/updateSalaryStructure/{id}")
    public SalaryStructure updateSalaryStructure(@PathVariable("id") int structureId,
                                   @RequestBody SalaryStructure salaryStructure) {
        return salaryStructureService.updateSalaryStructure(structureId, salaryStructure);
    }
}
