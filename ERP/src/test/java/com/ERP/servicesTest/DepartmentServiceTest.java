package com.ERP.servicesTest;

import com.ERP.dtos.DepartmentDto;
import com.ERP.dtos.ProjectDto;
import com.ERP.entities.Department;
import com.ERP.entities.Project;
import com.ERP.repositories.DepartmentRepository;
import com.ERP.repositories.ProjectRepository;
import com.ERP.services.DepartmentService;
import com.ERP.services.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DepartmentServiceTest
{
    private DepartmentRepository departmentRepository;
    private ObjectMapper objectMapper;
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        departmentRepository = Mockito.mock(DepartmentRepository.class);
        objectMapper = new ObjectMapper(); // Initialize objectMapper
        departmentService = new DepartmentService(departmentRepository, objectMapper);
    }

    Department department1= Department.builder().name("IT").build();
    Department department2= Department.builder().name("Project Management").build();
    Department department3= Department.builder().name("Employee Management").build();

    @Test
    public void createDepartmentTest() {
        BDDMockito.given(departmentRepository.save(department1)).willReturn(department1);
        DepartmentDto departmentDto = objectMapper.convertValue(department1, DepartmentDto.class);
        DepartmentDto savedDepartment = departmentService.addDepartment(departmentDto);
        Assertions.assertThat(savedDepartment).isNotNull();
    }

    @Test
    public void createAllDepartmentsTest()
    {
        List<Department> departments= new ArrayList<>();
        departments.add(department2);
        departments.add(department3);
        BDDMockito.given(departmentRepository.saveAll(departments)).willReturn(departments);
        List<DepartmentDto> departmentDtos= Arrays.asList(objectMapper.convertValue(departments,DepartmentDto[].class));
        List<DepartmentDto> savedDepartments= departmentService.addAllDepartment(departmentDtos) ;
        Assertions.assertThat(savedDepartments.get(0).getName()).isEqualTo(department2.getName());
        Assertions.assertThat(savedDepartments.get(1).getName()).isEqualTo(department3.getName());
    }

    @Test
    public void updateDepartmentTest() {
        long departmentId = 1L;
        Department existingDepartment = department1;
        DepartmentDto departmentDto= objectMapper.convertValue(department1,DepartmentDto.class);
        BDDMockito.given(departmentRepository.findById(departmentId)).willReturn(java.util.Optional.of(existingDepartment));
        when(departmentRepository.save(any(Department.class))).thenReturn(existingDepartment);
        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentDto, departmentId);
        Assertions.assertThat(updatedDepartment).isNotNull();
    }

}
