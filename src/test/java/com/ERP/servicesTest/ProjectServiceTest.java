package com.ERP.servicesTest;

import com.ERP.dtos.ProjectDto;
import com.ERP.entities.Project;
import com.ERP.repositories.ProjectRepository;
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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class ProjectServiceTest {

    private ProjectRepository projectRepository;
    private ObjectMapper objectMapper;
    private ProjectService projectService;

    @BeforeEach
    public void setUp() {
        projectRepository = Mockito.mock(ProjectRepository.class);
        objectMapper = new ObjectMapper(); // Initialize objectMapper
        projectService = new ProjectService(projectRepository, objectMapper);
    }

    Date startDate = Date.valueOf("2024-04-23");
    Date endDate = Date.valueOf("2024-04-29");
    Project project1 = Project.builder().name("ERP").description("This is ERP Project").startDate(startDate).endDate(endDate).status("pending").build();
    Project project2= Project.builder().name("CRM").description("This is CRM Project").startDate(startDate).endDate(endDate).status("processing").build();
    Project project3= Project.builder().name("HR").description("This is HR Project").startDate(startDate).endDate(endDate).status("done").build();

    @Test
    public void createProjectTest() {
        // Mocking save method of projectRepository
        BDDMockito.given(projectRepository.save(project1)).willReturn(project1);

        // Convert project1 to ProjectDto using objectMapper
        ProjectDto projectDto = objectMapper.convertValue(project1, ProjectDto.class);

        // Call the method under test
        ProjectDto savedProject = projectService.addProject(projectDto);

        // Assert that the saved project is not null
        Assertions.assertThat(savedProject).isNotNull();
    }

    @Test
    public void createAllProjectsTest()
    {
        List<Project> projects= new ArrayList<>();
        projects.add(project2);
        projects.add(project3);
        BDDMockito.given(projectRepository.saveAll(projects)).willReturn(projects);
        List<ProjectDto> projectDtos= Arrays.asList(objectMapper.convertValue(projects,ProjectDto[].class));
        List<ProjectDto> savedProjects= projectService.addAllProject(projectDtos) ;
        Assertions.assertThat(savedProjects.get(0).getName()).isEqualTo(project2.getName());
        Assertions.assertThat(savedProjects.get(1).getName()).isEqualTo(project3.getName());
    }

    @Test
    public void updateProjectTest() {
        // Mock data
        long projectId = 1L;
        Project existingProject = project1;
        ProjectDto projectDto= objectMapper.convertValue(project1,ProjectDto.class);

        // Mock behavior
        BDDMockito.given(projectRepository.findById(projectId)).willReturn(java.util.Optional.of(existingProject));
        when(projectRepository.save(any(Project.class))).thenReturn(existingProject);

        // Call the method under test
        ProjectDto updatedProject = projectService.updateProject(projectDto, projectId);

        // Assertions
       Assertions.assertThat(updatedProject).isNotNull();
        // Add assertions based on the expected behavior of updateProject method
    }

    @Test
    public void deleteProjectTest() {
        // Mock data
        long projectId = 1L;
        Project existingProject = project2;
        // Mock behavior
        given(projectRepository.findById(projectId)).willReturn(java.util.Optional.of(existingProject));

        // Call the method under test
        ProjectDto deletedProject = projectService.deleteProject(projectId);

        // Assertions
        Assertions.assertThat(deletedProject).isNotNull();
        // Add assertions based on the expected behavior of deleteProject method
    }

    @Test
    public void findProjectTest() {
        // Mock data
        long projectId = 1L;
        Project existingProject = project1;

        // Mock behavior
        given(projectRepository.findById(projectId)).willReturn(java.util.Optional.of(existingProject));

        // Call the method under test
        ProjectDto foundProject = projectService.findProject(projectId);

        // Assertions
        Assertions.assertThat(foundProject).isNotNull();
        // Add assertions based on the expected behavior of findProject method
    }

    @Test
    public void findAllProjectTest() {
        // Mock data
        List<Project> projectList = Arrays.asList(project2, project3); // Add necessary fields for projects

        // Mock behavior
        given(projectRepository.findAll()).willReturn(projectList);

        // Call the method under test
        List<ProjectDto> foundProjects = projectService.findAllProject();

        // Assertions
        Assertions.assertThat(foundProjects).isNotNull();
        Assertions.assertThat(foundProjects.size()).isEqualTo(projectList.size());
        // Add assertions based on the expected behavior of findAllProject method
    }


}
