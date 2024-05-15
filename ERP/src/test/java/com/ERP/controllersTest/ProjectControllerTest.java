package com.ERP.controllersTest;

import com.ERP.controllers.ProjectController;
import com.ERP.dtos.ProjectDto;
import com.ERP.entities.Project;
import com.ERP.services.ProjectService;
import com.ERP.entitiesTest.JsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//org.springframework.security.test.context.support.WithMockUser
//import org.springframework.security.test.context.support.WithMockUser;

@WebMvcTest(ProjectController.class)
//@WithMockUser
public class ProjectControllerTest
{
    @MockBean
    ProjectService projectService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    Project project;

    JsonReader jsonReader = new JsonReader();
    Map<String, Object> dataMap = jsonReader.readFile("Project");

    //Access the datamap here
    String name = (String) dataMap.get("name");
    String description = (String) dataMap.get("description");
    String startDateString = (String) dataMap.get("startDate");
    String endDateString = (String) dataMap.get("endDate");
    Date startDate = Date.valueOf(startDateString);
    Date endDate = Date.valueOf(endDateString);
    String status = (String) dataMap.get("status");

    public ProjectControllerTest() throws IOException {
    }
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        project = new Project();
        project.setProjectId(1L);
        project.setName(name);
        project.setDescription(description);
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setStatus(status);
    }
    @Test
    public void testCreateProject() throws Exception {
        ProjectDto projectDto =objectMapper.convertValue(project, ProjectDto.class);
        when(projectService.addProject(projectDto)).thenReturn(projectDto);
        mockMvc.perform(post("/project/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(project)))
                .andExpect(status().isCreated());
    }

    @Test
    public void getProjectTest() throws Exception {
        ProjectDto projectDto =objectMapper.convertValue(project, ProjectDto.class);
        long projectId = 1L;
        projectDto.setProjectId(projectId);

        when(projectService.findProject(projectId)).thenReturn(projectDto);

        mockMvc.perform(get("/project/find/{projectId}", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(name));
    }

    @Test
    public void getAllProjectsTest() throws Exception {
        List<Project> projects= Arrays.asList(project,project);
        List<ProjectDto> projectDtos= Arrays.asList(objectMapper.convertValue(projects,ProjectDto[].class));
        projectService.addAllProject(projectDtos);
        when(projectService.findAllProject()).thenReturn(projectDtos);
        mockMvc.perform(get("/project/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(name));
    }

    @Test
    public void testUpdateProject() throws Exception {
//        long projectId = 57L;
        List<Project> projects= Arrays.asList(project,project);
        List<ProjectDto> projectDtos= (Arrays.asList(objectMapper.convertValue(projects,ProjectDto[].class)));
        projectService.addAllProject(projectDtos);
//        System.out.println("----------------------------------------------------------");
//        System.out.println(projectDtos);
        ProjectDto projectDto=projectDtos.get(0);
        System.out.println(projectDto);
        System.out.println(projectDto.getProjectId());
        projectDto.setProjectId(1L);
        System.out.println(projectDto.getProjectId());
//        ProjectDto projectDto= objectMapper.convertValue(project1,ProjectDto.class);
        when(projectService.updateProject(projectDto, projectDto.getProjectId())).thenReturn(projectDto);
        mockMvc.perform(put("/project/update/{projectId}", projectDto.getProjectId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projectDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteProject() throws Exception {
        // Create a project DTO from project3
        ProjectDto projectDto = objectMapper.convertValue(project, ProjectDto.class);
        projectDto.setProjectId(1L);
        // Mock the behavior to return the project DTO when delete is called
        when(projectService.deleteProject(projectDto.getProjectId())).thenReturn(projectDto);
        // Perform the delete request
        mockMvc.perform(delete("/project/delete/{projectId}", projectDto.getProjectId()))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddAllProjects() throws Exception {
        List<Project> projectsToAdd = Arrays.asList(project,project);
        List<ProjectDto> projectDtos= Arrays.asList(objectMapper.convertValue(projectsToAdd,ProjectDto[].class));
        when(projectService.addAllProject(projectDtos)).thenReturn(projectDtos);

        mockMvc.perform(post("/project/addAll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projectsToAdd)))
                .andExpect(status().isOk());
    }
}
