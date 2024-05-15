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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DepartmentServiceTest
{
    @Mock
    private DepartmentRepository departmentRepository;
    @Mock
    private ObjectMapper objectMapper;
    private DepartmentService departmentService;
    AutoCloseable autoCloseable;
    Department department1;
    Department department2;
    Department department3;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        departmentService = new DepartmentService(departmentRepository,objectMapper);
        department1= Department.builder().name("IT").build();
        department2= Department.builder().name("Project Management").build();
        department3= Department.builder().name("Employee Management").build();
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(Department.class);
        mock(DepartmentRepository.class);
        when(departmentRepository.save(department1)).thenReturn(department1);
        DepartmentDto departmentDto= objectMapper.convertValue(department1,DepartmentDto.class);
        assertThat(departmentService.addDepartment(departmentDto)).isEqualTo("Success");
    }

//    @Test
//    void testUpdateCloudVendor() {
//        mock(CloudVendor.class);
//        mock(CloudVendorRepository.class);
//
//        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
//        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Success");
//    }
//
//    @Test
//    void testDeleteCloudVendor() {
//        mock(CloudVendor.class);
//        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);
//
//        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository)
//                .deleteById(any());
//        assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("Success");
//    }
//
//    @Test
//    void testGetCloudVendor() {
//        mock(CloudVendor.class);
//        mock(CloudVendorRepository.class);
//
//        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
//
//        assertThat(cloudVendorService.getCloudVendor("1").getVendorName())
//                .isEqualTo(cloudVendor.getVendorName());
//    }
//
//    @Test
//    void testGetByVendorName() {
//        mock(CloudVendor.class);
//        mock(CloudVendorRepository.class);
//
//        when(cloudVendorRepository.findByVendorName("Amazon")).
//                thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
//
//        assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorId()).
//                isEqualTo(cloudVendor.getVendorId());
//    }
//
//    @Test
//    void testGetAllCloudVendors() {
//        mock(CloudVendor.class);
//        mock(CloudVendorRepository.class);
//
//        when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(
//                Collections.singleton(cloudVendor)
//        ));
//
//        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber()).
//                isEqualTo(cloudVendor.getVendorPhoneNumber());
//
//    }




//    private DepartmentRepository departmentRepository;
//    private ObjectMapper objectMapper;
//    private DepartmentService departmentService;
//
//    @BeforeEach
//    public void setUp() {
//        departmentRepository = Mockito.mock(DepartmentRepository.class);
//        objectMapper = new ObjectMapper(); // Initialize objectMapper
//        departmentService = new DepartmentService(departmentRepository, objectMapper);
//    }
//
//    Department department1= Department.builder().name("IT").build();
//    Department department2= Department.builder().name("Project Management").build();
//    Department department3= Department.builder().name("Employee Management").build();
//
//    @Test
//    public void createDepartmentTest() {
//        BDDMockito.given(departmentRepository.save(department1)).willReturn(department1);
//        DepartmentDto departmentDto = objectMapper.convertValue(department1, DepartmentDto.class);
//        DepartmentDto savedDepartment = departmentService.addDepartment(departmentDto);
//        Assertions.assertThat(savedDepartment).isNotNull();
//    }
//
//    @Test
//    public void createAllDepartmentsTest()
//    {
//        List<Department> departments= new ArrayList<>();
//        departments.add(department2);
//        departments.add(department3);
//        BDDMockito.given(departmentRepository.saveAll(departments)).willReturn(departments);
//        List<DepartmentDto> departmentDtos= Arrays.asList(objectMapper.convertValue(departments,DepartmentDto[].class));
//        List<DepartmentDto> savedDepartments= departmentService.addAllDepartment(departmentDtos) ;
//        Assertions.assertThat(savedDepartments.get(0).getName()).isEqualTo(department2.getName());
//        Assertions.assertThat(savedDepartments.get(1).getName()).isEqualTo(department3.getName());
//    }
//
//    @Test
//    public void updateDepartmentTest() {
//        long departmentId = 1L;
//        Department existingDepartment = department1;
//        DepartmentDto departmentDto= objectMapper.convertValue(department1,DepartmentDto.class);
//        BDDMockito.given(departmentRepository.findById(departmentId)).willReturn(java.util.Optional.of(existingDepartment));
//        when(departmentRepository.save(any(Department.class))).thenReturn(existingDepartment);
//        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentDto, departmentId);
//        Assertions.assertThat(updatedDepartment).isNotNull();
//    }

}
