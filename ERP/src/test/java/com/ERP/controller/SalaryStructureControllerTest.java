package com.ERP.controller;

import com.ERP.entity.SalaryStructure;
import com.ERP.service.SalaryStructureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SalaryStructureController.class)
class SalaryStructureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalaryStructureService salaryStructureService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getSalaryStructure() throws Exception {
        // Mock data
        SalaryStructure salaryStructure1 = new SalaryStructure();
        SalaryStructure salaryStructure2 = new SalaryStructure();
        List<SalaryStructure> salaryStructureList = Arrays.asList(salaryStructure1, salaryStructure2);

        // Mock service method
        when(salaryStructureService.fetchSalaryStructureList()).thenReturn(salaryStructureList);

        // Perform GET request
        mockMvc.perform(get("/salaryStructure"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void addSalaryStructure() throws Exception {
        SalaryStructure salaryStructure = SalaryStructure.builder()
                .level("intern")
                .baseSalary(3000.00)
                .role("developer")
                .structureId(1)
                .build();

        when(salaryStructureService.addSalaryStructure(salaryStructure)).thenReturn(salaryStructure);

        mockMvc.perform(post("/addSalaryStructure")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(salaryStructure)))
                .andExpect(status().isOk());
    }

    @Test
    void getSalaryStructureById() throws Exception {
        SalaryStructure salaryStructure = SalaryStructure.builder()
                .level("intern")
                .baseSalary(3000.00)
                .role("developer")
                .structureId(1)
                .build();

        when(salaryStructureService.fetchSalaryStructureById(1)).thenReturn(salaryStructure);

        mockMvc.perform(get("/salaryStructure/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.level").value("intern"));
    }

    @Test
    void fetchSalaryStructureByRole() throws Exception {
        SalaryStructure salaryStructure1 = SalaryStructure.builder()
                .level("intern")
                .baseSalary(3000.00)
                .role("developer")
                .structureId(1)
                .build();
        SalaryStructure salaryStructure2 = SalaryStructure.builder()
                .level("senior")
                .baseSalary(3000.00)
                .role("batter")
                .structureId(2)
                .build();

        List<SalaryStructure> salaryStructureList = Arrays.asList(salaryStructure1, salaryStructure2);

        when(salaryStructureService.fetchSalaryStructureByRole("developer")).thenReturn(salaryStructureList);
        mockMvc.perform(get("/salaryStructure/role/{role}", "developer")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].level").value("intern"));

    }

    @Test
    void removeSalaryStructure() throws Exception {
        SalaryStructure salaryStructure = SalaryStructure.builder()
                .level("intern")
                .baseSalary(3000.00)
                .role("developer")
                .structureId(1)
                .build();

        doNothing().when(salaryStructureService).removeSalaryStructure(1);
        mockMvc.perform(delete("/removeSalaryStructure/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(salaryStructure)))
                .andExpect(status().isOk());
    }

    @Test
    void updateSalaryStructure() throws Exception {
        // Prepare the salary structure object with updated values
        SalaryStructure existingSalaryStructure = SalaryStructure.builder()
                .level("intern")
                .baseSalary(3000.00)
                .role("developer")
                .structureId(1)
                .build();

        SalaryStructure updatedSalaryStructure = SalaryStructure.builder()
                .level("senior")
                .baseSalary(5000.00)
                .role("senior developer")
                .structureId(1)
                .build();

        // Mock the service behavior to update the salary structure
        when(salaryStructureService.updateSalaryStructure(eq(1), any(SalaryStructure.class)))
                .thenReturn(updatedSalaryStructure);

        // Perform PUT request to update the salary structure
        mockMvc.perform(put("/updateSalaryStructure/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updatedSalaryStructure)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.role").value("senior developer"));
    }
}