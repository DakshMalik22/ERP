package com.ERP.entitiesTest;

import com.ERP.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepartmentTest
{
    private Department department;

    @Mock
    private Project mockProject;

    @Mock
    private Employee mockEmployee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        department=department.builder()
                .departmentId(1L)
                .name("java developers")
                .build();
    }

    @Test
    void testConstructor() {
        Set<Project> projectSet = new HashSet<>();
        projectSet.add(mockProject);

        List<Employee> employees= new ArrayList<>();
        employees.add(mockEmployee);

        Department department = new Department(1L,"Java developers",projectSet,employees);
        Assertions.assertEquals(1L, department.getDepartmentId());
        Assertions.assertEquals("Java developers", department.getName());
        Assertions.assertEquals(projectSet, department.getProjectSet());
        Assertions.assertEquals(employees, department.getEmployees());
    }

    @Test
    void testGetters() {
        Set<Project> projectSet = new HashSet<>();
        projectSet.add(mockProject);
        department.setProjectSet(projectSet);

        List<Employee> employeeList = new ArrayList<>();
        department.setEmployees(employeeList);

        Assertions.assertEquals(1L, department.getDepartmentId());
        Assertions.assertEquals("java developers", department.getName());
        Assertions.assertEquals(department.getProjectSet(),projectSet);
        Assertions.assertEquals(department.getEmployees(),employeeList);
    }

    @Test
    void testSetters() {
        department.setDepartmentId(2L);
        department.setName("Updated Department");
        Set<Project> projectSet= new HashSet<>();
        projectSet.add(mockProject);
        department.setProjectSet(projectSet);

        List<Employee> employees = new ArrayList<>();
        employees.add(mockEmployee);
        department.setEmployees(employees);

        Assertions.assertEquals(2L, department.getDepartmentId());
        Assertions.assertEquals("Updated Department", department.getName());
        Assertions.assertEquals(projectSet, department.getProjectSet());
        Assertions.assertEquals(employees, department.getEmployees());
    }
}
