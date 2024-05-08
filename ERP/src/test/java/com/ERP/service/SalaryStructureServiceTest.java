package com.ERP.service;

import com.ERP.entity.SalaryStructure;
import com.ERP.error.SalaryStructureNotFoundException;
import com.ERP.repository.SalaryStructureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class SalaryStructureServiceTest {

    @Autowired
    private SalaryStructureService salaryStructureService;

    @MockBean
    private SalaryStructureRepository salaryStructureRepository;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.initMocks(this);
    }

    @Test
    void fetchSalaryStructureList() {
        SalaryStructure salaryStructure1 = SalaryStructure.builder()
                .level("intern")
                .baseSalary(3000.00)
                .role("developer")
                .structureId(1)
                .build();

        SalaryStructure salaryStructure2 = SalaryStructure.builder()
                .level("senior")
                .baseSalary(5000.00)
                .role("engineer")
                .structureId(2)
                .build();

        List<SalaryStructure> mockedList = Arrays.asList(salaryStructure1, salaryStructure2);

        // Mocking behavior of repository
        when(salaryStructureRepository.findAll()).thenReturn(mockedList);

        // Call the method to be tested
        List<SalaryStructure> result = salaryStructureService.fetchSalaryStructureList();

        assertSame(mockedList, result); // Assuming you want to check reference equality
        assertEquals(2, result.size()); // Check the size of the returned list
        assertEquals("intern", result.get(0).getLevel()); // Check the first SalaryStructure object
        assertEquals("senior", result.get(1).getLevel()); // Check the second SalaryStructure object
        // Similarly, you can add more assertions to validate other attributes of the SalaryStructure objects
    }

    @Test
    void fetchSalaryStructureById() {
        // Mock data
        SalaryStructure mockSalaryStructure = SalaryStructure.builder()
                .level("intern")
                .baseSalary(3000.00)
                .role("developer")
                .structureId(1)
                .build();

        // Mocking behavior of repository
        when(salaryStructureRepository.findById(1)).thenReturn(Optional.of(mockSalaryStructure));

        try {
            // Call the method to be tested
            SalaryStructure result = salaryStructureService.fetchSalaryStructureById(1);
            // Assertions
            assertEquals(mockSalaryStructure, result); // Check if the returned optional matches the expected mock optional
        } catch (SalaryStructureNotFoundException salaryStructureNotFoundException) {
            // Handle the exception or fail the test if necessary
            System.out.println("No Salary Structure for this Structure Id");
        }
    }

    @Test
    void addSalaryStructure() {
        // Mock data
        SalaryStructure salaryStructureToAdd = SalaryStructure.builder()
                .level("intern")
                .baseSalary(3000.00)
                .role("developer")
                .structureId(1)
                .build();

        // Mocking behavior of repository
        when(salaryStructureRepository.save(any())).thenReturn(salaryStructureToAdd);

        // Call the method to be tested
        SalaryStructure addedSalaryStructure = salaryStructureService.addSalaryStructure(salaryStructureToAdd);

        // Verify that the repository's save method was called with the correct parameter
        verify(salaryStructureRepository).save(salaryStructureToAdd);

        // Assertions
        assertEquals(salaryStructureToAdd, addedSalaryStructure); // Check if the returned object matches the mock object
    }

    @Test
    void fetchSalaryStructureByRole() {
        // Mock data
        SalaryStructure salaryStructure1 = SalaryStructure.builder()
                .level("intern")
                .baseSalary(3000.00)
                .role("developer")
                .structureId(1)
                .build();
        SalaryStructure salaryStructure2 = SalaryStructure.builder()
                .level("senior")
                .baseSalary(5000.00)
                .role("developer")
                .structureId(2)
                .build();
        List<SalaryStructure> mockedList = Arrays.asList(salaryStructure1, salaryStructure2);

        // Mocking behavior of repository
        when(salaryStructureRepository.findAllByRole("developer")).thenReturn(mockedList);

        try {
            // Call the method to be tested
            List<SalaryStructure> result = salaryStructureService.fetchSalaryStructureByRole("developer");

            // Assertions
            assertEquals(2, result.size()); // Check if the correct number of salary structures is returned
            assertEquals("developer", result.get(0).getRole()); // Check if the role of the first salary structure is "developer"
            assertEquals("developer", result.get(1).getRole()); // Check if the role of the second salary structure is "developer"
            // Add more assertions to validate other attributes if needed
        } catch (SalaryStructureNotFoundException salaryStructureNotFoundException) {
            // Handle the exception or fail the test if necessary
            System.out.println("No Salary Structure found for this Role");
        }
    }

    @Test
    void removeSalaryStructure() {
        // Mock data
        SalaryStructure mockSalaryStructure = SalaryStructure.builder()
                .level("intern")
                .baseSalary(3000.00)
                .role("developer")
                .structureId(1)
                .build();

        // Mocking behavior of repository
        when(salaryStructureRepository.findById(1)).thenReturn(Optional.of(mockSalaryStructure));

        // Call the method to be tested
        salaryStructureService.removeSalaryStructure(1);

        // Verify that the repository's deleteById method was called with the correct parameter
        verify(salaryStructureRepository).deleteById(1);
    }

    @Test
    void updateSalaryStructure() {
        // Mock data
        SalaryStructure existingSalaryStructure = SalaryStructure.builder()
                .level("intern")
                .baseSalary(3000.00)
                .role("developer")
                .structureId(1)
                .build();
        SalaryStructure updatedSalaryStructure = SalaryStructure.builder()
                .level("senior")
                .baseSalary(5000.00)
                .role("engineer")
                .structureId(1)
                .build();

        // Mocking behavior of repository
        when(salaryStructureRepository.findById(1)).thenReturn(Optional.of(existingSalaryStructure));
        when(salaryStructureRepository.save(updatedSalaryStructure)).thenReturn(updatedSalaryStructure);

        // Call the method to be tested
        salaryStructureService.updateSalaryStructure(1, updatedSalaryStructure);

        // Verify that the repository's findById and save methods were called with the correct parameters
        verify(salaryStructureRepository).findById(1);
        verify(salaryStructureRepository).save(updatedSalaryStructure);
    }
}