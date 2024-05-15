package com.ERP.repositoriesTest;

import com.ERP.entities.Department;
import com.ERP.repositories.DepartmentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DepartmentRepositoryTest
{
    @Autowired
    private DepartmentRepository departmentRepository;

    Department department1= Department.builder().name("IT").build();
    Department department2= Department.builder().name("Project Management").build();
    Department department3= Department.builder().name("Employee Management").build();

    @Test
    public void saveDepartmentTest() {
        departmentRepository.save(department1);
        Assertions.assertThat(department1.getDepartmentId()).isGreaterThan(0);
        Assertions.assertThat(department1.getName()).isEqualTo("IT");
    }

    @Test
    public void findDepartmentById()
    {
        List<Department> departmentList= departmentRepository.findAll();
        Department departmentToFind= departmentList.get(0);
        Department department= departmentRepository.findById(departmentToFind.getDepartmentId()).get();
        Assertions.assertThat(department.getDepartmentId()).isEqualTo(departmentToFind.getDepartmentId());
    }

    @Test
    public void findAllDepartments()
    {
        List<Department> departmentList= departmentRepository.findAll();
        Assertions.assertThat(departmentList.size()).isGreaterThan(0);
    }

    @Test
    public void updateDepartment()
    {
        List<Department> departmentList= departmentRepository.findAll();
        Department departmentToFind= departmentList.get(0);
        Department department= departmentRepository.findById(departmentToFind.getDepartmentId()).get();
        department.setName("updated Department");
        Department savedDepartment= departmentRepository.save(department);
        Assertions.assertThat(savedDepartment.getName()).isEqualTo("updated Department");
    }

    @Test
    public void deleteDepartment()
    {
        List<Department> departmentList= departmentRepository.findAll();
        Department departmentToDelete= departmentList.get(0);
        departmentRepository.delete(departmentToDelete);
        Department deletedDepartment= null;
        Optional<Department> optionalDepartment= departmentRepository.findById(departmentToDelete.getDepartmentId());
        if(optionalDepartment.isPresent())
        {
            deletedDepartment=optionalDepartment.get();
        }
        Assertions.assertThat(deletedDepartment).isNull();
    }

    @Test
    public void addAll()
    {
        List<Department> departmentsToAdd= new ArrayList<>();
        departmentsToAdd.add(department2);
        departmentsToAdd.add(department3);
        List<Department> addDepartments= departmentRepository.saveAll(departmentsToAdd);
        Assertions.assertThat(addDepartments.get(0).getName()).isEqualTo(department2.getName());
        Assertions.assertThat(addDepartments.get(1).getName()).isEqualTo(department3.getName());
    }
//    @Test
//    public void findByNameTest()
//    {
//        List<Department> departments= departmentRepository.findAll();
//        Department departmentToFind= departments.get(0);
//        Department department= departmentRepository.findById(departmentToFind.getDepartmentId()).get();
//        Assertions.assertThat(department.getName()).isEqualTo(departmentToFind.getName());
//    }

}
