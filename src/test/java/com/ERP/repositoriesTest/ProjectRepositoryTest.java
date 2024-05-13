package com.ERP.repositoriesTest;

import com.ERP.entities.Project;
import com.ERP.repositories.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
//@Transactional   = it is used so that our data will not be saved in database
public class ProjectRepositoryTest {
    @Autowired
    private ProjectRepository projectRepository;

    Date startDate = Date.valueOf("2024-04-23");
    Date endDate = Date.valueOf("2024-04-29");
    Project project1= Project.builder().name("ERP").description("This is ERP Project").startDate(startDate).endDate(endDate).status("pending").build();
    Project project2= Project.builder().name("CRM").description("This is CRM Project").startDate(startDate).endDate(endDate).status("processing").build();
    Project project3= Project.builder().name("HR").description("This is HR Project").startDate(startDate).endDate(endDate).status("done").build();

    @Test
    public void saveProjectTest() {
        projectRepository.save(project1);
        Assertions.assertThat(project1.getProjectId()).isGreaterThan(0);
        Assertions.assertThat(project1.getName()).isEqualTo("ERP");
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
        projectsToAdd.add(project2);
        projectsToAdd.add(project3);
        List<Project> addProjects= projectRepository.saveAll(projectsToAdd);
        Assertions.assertThat(addProjects.get(0).getName()).isEqualTo(project2.getName());
        Assertions.assertThat(addProjects.get(1).getName()).isEqualTo(project3.getName());
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