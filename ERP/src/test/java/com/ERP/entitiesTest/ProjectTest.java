package com.ERP.entitiesTest;

import com.ERP.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
@ExtendWith(MockitoExtension.class)
class ProjectTest {

    private Project project;

    @Mock
    private Client mockClient;

    @Mock
    private Department mockDepartment;

    @Mock
    private Task mockTask;

    @Mock
    private Asset mockAsset;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        project = Project.builder()
                .projectId(1L)
                .name("Test Project")
                .description("This is a test project")
                .startDate(Date.valueOf("2023-05-01"))
                .endDate(Date.valueOf("2023-12-31"))
                .status("Active")
                .client(mockClient)
                .department(mockDepartment)
                .build();
    }

    @Test
    void testConstructor() {
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(mockTask);

        Set<Invoice> invoiceSet = new HashSet<>();

        Set<Asset> assetSet = new HashSet<>();
        assetSet.add(mockAsset);

        Project project = new Project(1L, "Test Project", "This is a test project", Date.valueOf("2023-05-01"), Date.valueOf("2023-12-31"), "Active", taskSet, invoiceSet, mockClient, mockDepartment, assetSet);

        Assertions.assertEquals(1L, project.getProjectId());
        Assertions.assertEquals("Test Project", project.getName());
        Assertions.assertEquals("This is a test project", project.getDescription());
        Assertions.assertEquals(Date.valueOf("2023-05-01"), project.getStartDate());
        Assertions.assertEquals(Date.valueOf("2023-12-31"), project.getEndDate());
        Assertions.assertEquals("Active", project.getStatus());
        Assertions.assertEquals(taskSet, project.getTaskSet());
        Assertions.assertEquals(invoiceSet, project.getInvoiceSet());
        Assertions.assertEquals(mockClient, project.getClient());
        Assertions.assertEquals(mockDepartment, project.getDepartment());
        Assertions.assertEquals(assetSet, project.getAssetSet());
    }

    @Test
    void testGetters() {
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(mockTask);
        project.setTaskSet(taskSet);

        Set<Invoice> invoiceSet = new HashSet<>();
        project.setInvoiceSet(invoiceSet);

        Set<Asset> assetSet = new HashSet<>();
        assetSet.add(mockAsset);
        project.setAssetSet(assetSet);

        Assertions.assertEquals(1L, project.getProjectId());
        Assertions.assertEquals("Test Project", project.getName());
        Assertions.assertEquals("This is a test project", project.getDescription());
        Assertions.assertEquals(Date.valueOf("2023-05-01"), project.getStartDate());
        Assertions.assertEquals(Date.valueOf("2023-12-31"), project.getEndDate());
        Assertions.assertEquals("Active", project.getStatus());
        Assertions.assertEquals(project.getTaskSet(),taskSet);
        Assertions.assertEquals(project.getInvoiceSet(),invoiceSet);
        Assertions.assertTrue(project.getInvoiceSet().isEmpty());
        Assertions.assertEquals(mockClient, project.getClient());
        Assertions.assertEquals(mockDepartment, project.getDepartment());
        Assertions.assertEquals(assetSet, project.getAssetSet());
    }

    @Test
    void testSetters() {
        project.setProjectId(2L);
        project.setName("Updated Project");
        project.setDescription("This is an updated project");
        project.setStartDate(Date.valueOf("2023-06-01"));
        project.setEndDate(Date.valueOf("2024-06-30"));
        project.setStatus("Completed");
        project.setClient(mockClient);
        project.setDepartment(mockDepartment);

        Set<Task> taskSet = new HashSet<>();
        taskSet.add(mockTask);
        project.setTaskSet(taskSet);

        Set<Invoice> invoiceSet = new HashSet<>();
        project.setInvoiceSet(invoiceSet);

        Set<Asset> assetSet = new HashSet<>();
        assetSet.add(mockAsset);
        project.setAssetSet(assetSet);

        Assertions.assertEquals(2L, project.getProjectId());
        Assertions.assertEquals("Updated Project", project.getName());
        Assertions.assertEquals("This is an updated project", project.getDescription());
        Assertions.assertEquals(Date.valueOf("2023-06-01"), project.getStartDate());
        Assertions.assertEquals(Date.valueOf("2024-06-30"), project.getEndDate());
        Assertions.assertEquals("Completed", project.getStatus());
        Assertions.assertEquals(taskSet, project.getTaskSet());
        Assertions.assertEquals(invoiceSet, project.getInvoiceSet());
        Assertions.assertEquals(mockClient, project.getClient());
        Assertions.assertEquals(mockDepartment, project.getDepartment());
        Assertions.assertEquals(assetSet, project.getAssetSet());
    }
}