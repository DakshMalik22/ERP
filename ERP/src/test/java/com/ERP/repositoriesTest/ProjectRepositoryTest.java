package com.ERP.repositoriesTest;

import com.ERP.entities.Project;
import com.ERP.entitiesTest.JsonReader;
import com.ERP.repositories.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
//@Transactional   = it is used so that our data will not be saved in database
public class ProjectRepositoryTest {
    @Autowired
    private ProjectRepository projectRepository;

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

    ProjectRepositoryTest() throws IOException {
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
    public void saveProjectTest() {
        projectRepository.save(project);
        Assertions.assertThat(project.getProjectId()).isGreaterThan(0);
        Assertions.assertThat(project.getName()).isEqualTo(name);
    }

    @Test
    public void findProjectById()
    {
        List<Project> projects= projectRepository.findAll();
        //Rather then giving a particular id here I have given the id for the project present at 0th index in database
        Project projectToFind= projects.get(0);
        Project project= projectRepository.findById(projectToFind.getProjectId()).get();   //(because project with id 19 is already present in DB)
        Assertions.assertThat(project.getProjectId()).isEqualTo(projectToFind.getProjectId());
    }
    @Test
    public void findAllProjects()
    {
        List<Project> projects= projectRepository.findAll();
        Assertions.assertThat(projects.size()).isGreaterThan(0);
    }

    @Test
    public void updateProject()
    {
        List<Project> projects= projectRepository.findAll();
        //Rather then giving a particular id here I have given the id for the project present at 0th index in database
        Project projectToFind= projects.get(0);
        Project project= projectRepository.findByName(projectToFind.getName()).get(0);
        project.setStatus("done...");
        Project savedProject= projectRepository.save(project);
        Assertions.assertThat(savedProject.getStatus()).isEqualTo("done...");
    }

    @Test
    public void deleteProject()
    {
        List<Project> projects= projectRepository.findAll();
        //Rather then giving a particular id here I have given the id for the project present at 1st index in database
        Project projectToDelete= projects.get(0);
//      Project project= projectRepository.findById(20L).get();
        projectRepository.delete(projectToDelete);
        Project deletedProject= null;
        Optional<Project> optionalProject= projectRepository.findById(projectToDelete.getProjectId());
        if(optionalProject.isPresent())
        {
            deletedProject=optionalProject.get();
        }
        Assertions.assertThat(deletedProject).isNull();
    }
    @Test
    public void addAll()
    {
        List<Project> projectsToAdd= new ArrayList<>();
        projectsToAdd.add(project);
        projectsToAdd.add(project);
        List<Project> addProjects= projectRepository.saveAll(projectsToAdd);
        Assertions.assertThat(addProjects.get(0).getName()).isEqualTo(project.getName());
        Assertions.assertThat(addProjects.get(1).getName()).isEqualTo(project.getName());
    }
    @Test
    public void findByNameTest()
    {
        List<Project> projects= projectRepository.findAll();
        //Rather then giving a particular name here I have given the name for the project present at 0th index in database
        Project projectToFind= projects.get(0);
        Project project= projectRepository.findByName(projectToFind.getName()).get(0);   //(because project with id 19 is already present in DB)
        Assertions.assertThat(project.getName()).isEqualTo(projectToFind.getName());
    }
}