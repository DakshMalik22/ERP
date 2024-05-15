package com.ERP.entitiesTest;

import com.ERP.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.sql.Date;
import java.util.HashSet;
import java.util.Map;
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
    Set<Task> taskSet;
    Set<Invoice> invoiceSet;
    Set<Asset> assetSet;

    JsonReader jsonReader = new JsonReader();
    Map<String, Object> dataMap = jsonReader.readFile("Project");

    String name = (String) dataMap.get("name");
    String description = (String) dataMap.get("description");
    String startDateString = (String) dataMap.get("startDate");
    String endDateString = (String) dataMap.get("endDate");
    Date startDate = Date.valueOf(startDateString);
    Date endDate = Date.valueOf(endDateString);
    String status = (String) dataMap.get("status");

    ProjectTest() throws IOException {
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        project= new Project();
        project.setProjectId(1L);
        project.setName(name);
        project.setDescription(description);
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setStatus(status);
        project.setClient(mockClient);
        project.setDepartment(mockDepartment);

        taskSet = new HashSet<>();
        taskSet.add(mockTask);
        project.setTaskSet(taskSet);

        invoiceSet= new HashSet<>();
        project.setInvoiceSet(invoiceSet);

        assetSet = new HashSet<>();
        assetSet.add(mockAsset);
        project.setAssetSet(assetSet);
    }

    @Test
    void testConstructor() {
        Assertions.assertEquals(1L, project.getProjectId());
        Assertions.assertEquals(name, project.getName());
        Assertions.assertEquals(description, project.getDescription());
        Assertions.assertEquals(startDate, project.getStartDate());
        Assertions.assertEquals(endDate, project.getEndDate());
        Assertions.assertEquals(status, project.getStatus());
        Assertions.assertEquals(taskSet, project.getTaskSet());
        Assertions.assertEquals(invoiceSet, project.getInvoiceSet());
        Assertions.assertEquals(mockClient, project.getClient());
        Assertions.assertEquals(mockDepartment, project.getDepartment());
        Assertions.assertEquals(assetSet, project.getAssetSet());
    }

    @Test
    void testGetters() {
        Assertions.assertEquals(1L, project.getProjectId());
        Assertions.assertEquals(name, project.getName());
        Assertions.assertEquals(description, project.getDescription());
        Assertions.assertEquals(startDate, project.getStartDate());
        Assertions.assertEquals(endDate, project.getEndDate());
        Assertions.assertEquals(status, project.getStatus());
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