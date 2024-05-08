package com.ERP.service;

import com.ERP.entity.HR;
import com.ERP.error.HRNotFoundException;
import com.ERP.repository.HRRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HRServiceTest {
    @Autowired
    private HRService hrService;

    @MockBean
    private HRRepository hrRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void fetchHRList() {
        HR hr1 = HR.builder()
                .name("rajkumar")
                .password("hello123")
                .role("senior HR")
                .hrId(1)
                .build();

        HR hr2 = HR.builder()
                .name("rajkumar2")
                .password("hello1232")
                .role("senior HR2")
                .hrId(2)
                .build();

        List<HR> mockedList = Arrays.asList(hr1, hr2);

        // Mocking behavior of repository
        when(hrRepository.findAll()).thenReturn(mockedList);

        // Call the method to be tested
        List<HR> result = hrService.fetchHRList();

        assertSame(mockedList, result); // Assuming you want to check reference equality
        assertEquals(2, result.size()); // Check the size of the returned list
        assertEquals("senior HR", result.get(0).getRole()); // Check the first SalaryStructure object
        assertEquals("senior HR2", result.get(1).getRole()); // Check the second SalaryStructure object
        // Similarly, you can add more assertions to validate other attributes of the SalaryStructure objects
    }

    @Test
    void fetchHRById() {
        // Mock data
        HR mockHR = HR.builder()
                .name("rajkumar")
                .password("hello123")
                .role("senior HR")
                .hrId(1)
                .build();

        // Mocking behavior of repository
        when(hrRepository.findById(1)).thenReturn(Optional.of(mockHR));

        try {
            // Call the method to be tested
            HR result = hrService.fetchHRById(1);
            // Assertions
            assertEquals(mockHR, result); // Check if the returned optional matches the expected mock optional
        } catch (HRNotFoundException hrNotFoundException) {
            // Handle the exception or fail the test if necessary
            System.out.println("No HR for this HR Id");
        }
    }

    @Test
    void addHR() {
        // Mock data
        HR hr = HR.builder()
                .name("rajkumar")
                .password("hello123")
                .role("senior HR")
                .hrId(1)
                .build();

        // Mocking behavior of repository
        when(hrRepository.save(any())).thenReturn(hr);

        // Call the method to be tested
        HR addedHR = hrService.addHR(hr);

        // Verify that the repository's save method was called with the correct parameter
        verify(hrRepository).save(hr);

        // Assertions
        assertEquals(hr, addedHR); // Check if the returned object matches the mock object
    }

    @Test
    void removeHR() {
        // Mock data
        HR mockHR = HR.builder()
                .name("rajkumar")
                .password("hello123")
                .role("senior HR")
                .hrId(1)
                .build();

        // Mocking behavior of repository
        when(hrRepository.findById(1)).thenReturn(Optional.of(mockHR));

        // Call the method to be tested
        hrService.removeHR(1);

        // Verify that the repository's deleteById method was called with the correct parameter
        verify(hrRepository).deleteById(1);
    }

    @Test
    void updateHR() {
        HR existingHR = HR.builder()
                .name("rajkumar")
                .password("hello123")
                .role("senior HR")
                .hrId(1)
                .build();

        HR updatedHR = HR.builder()
                .name("rajkumar2")
                .password("hello1232")
                .role("senior HR2")
                .hrId(1)
                .build();

        // Mocking behavior of repository
        when(hrRepository.findById(1)).thenReturn(Optional.of(existingHR));
        when(hrRepository.save(updatedHR)).thenReturn(updatedHR);

        // Call the method to be tested
        hrService.updateHR(1, updatedHR);

        // Verify that the repository's findById and save methods were called with the correct parameters
        verify(hrRepository).findById(1);
        verify(hrRepository).save(updatedHR);
    }
}
