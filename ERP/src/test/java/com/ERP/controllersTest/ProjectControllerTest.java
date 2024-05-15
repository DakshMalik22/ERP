package com.ERP.controllersTest;

import com.ERP.controllers.ProjectController;
import com.ERP.dtos.ProjectDto;
import com.ERP.entities.Project;
import com.ERP.services.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

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

    Date startDate = Date.valueOf("2024-04-23");
    Date endDate = Date.valueOf("2024-04-29");
    Project project1= Project.builder().name("ERP").description("This is ERP Project").startDate(startDate).endDate(endDate).status("pending").build();
    Project project2= Project.builder().name("CRM").description("This is CRM Project").startDate(startDate).endDate(endDate).status("processing").build();
    Project project3= Project.builder().name("HR").description("This is HR Project").startDate(startDate).endDate(endDate).status("done").build();

    @Test
    public void testCreateProject() throws Exception {
        ProjectDto projectDto =objectMapper.convertValue(project1, ProjectDto.class);
        when(projectService.addProject(projectDto)).thenReturn(projectDto);
        mockMvc.perform(post("/project/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(project1)))
                .andExpect(status().isCreated());
    }

    @Test
    public void getProjectTest() throws Exception {
        ProjectDto projectDto =objectMapper.convertValue(project1, ProjectDto.class);
        long projectId = 1L;
        projectDto.setProjectId(projectId);

        when(projectService.findProject(projectId)).thenReturn(projectDto);

        mockMvc.perform(get("/project/find/{projectId}", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value("ERP"));
    }

    @Test
    public void getAllProjectsTest() throws Exception {
        List<Project> projects= Arrays.asList(project2,project3);
        List<ProjectDto> projectDtos= Arrays.asList(objectMapper.convertValue(projects,ProjectDto[].class));
        projectService.addAllProject(projectDtos);
        when(projectService.findAllProject()).thenReturn(projectDtos);
        mockMvc.perform(get("/project/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("CRM"));
    }

    @Test
    public void testUpdateProject() throws Exception {
//        long projectId = 57L;
        List<Project> projects= Arrays.asList(project2,project3);
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
        ProjectDto projectDto = objectMapper.convertValue(project3, ProjectDto.class);
        projectDto.setProjectId(1L);
        // Mock the behavior to return the project DTO when delete is called
        when(projectService.deleteProject(projectDto.getProjectId())).thenReturn(projectDto);
        // Perform the delete request
        mockMvc.perform(delete("/project/delete/{projectId}", projectDto.getProjectId()))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddAllProjects() throws Exception {
        List<Project> projectsToAdd = Arrays.asList(
                Project.builder().name("Project 1").description("Description 1").build(),
                Project.builder().name("Project 2").description("Description 2").build()
        );
        List<ProjectDto> projectDtos= Arrays.asList(objectMapper.convertValue(projectsToAdd,ProjectDto[].class));
        when(projectService.addAllProject(projectDtos)).thenReturn(null);

        mockMvc.perform(post("/project/addAll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projectsToAdd)))
                .andExpect(status().isOk());
    }
}
