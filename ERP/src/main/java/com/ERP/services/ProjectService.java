package com.ERP.services;

import com.ERP.dtos.ProjectDto;
import com.ERP.entities.Project;
import com.ERP.repositories.ProjectRepository;
import com.ERP.servicesInter.ProjectServiceInter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectService implements ProjectServiceInter
{
    private ProjectRepository projectRepository;
    private ObjectMapper objectMapper;

    public ProjectService(ProjectRepository projectRepository, ObjectMapper objectMapper)
    {
        this.projectRepository=projectRepository;
        this.objectMapper=objectMapper;
    }
    @Override
    public ProjectDto addProject(ProjectDto projectDto)
    {
        Project newProject =objectMapper.convertValue(projectDto, Project.class);
        projectRepository.save(newProject);
        return objectMapper.convertValue(newProject,ProjectDto.class);
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto, long projectId)
    {
        Project project= projectRepository.findById(projectId).get();
        Project project1= objectMapper.convertValue(projectDto,Project.class);
        project1.setProjectId(projectId);
        projectRepository.save(project1);
        return objectMapper.convertValue(project, ProjectDto.class);
    }

    @Override
    public ProjectDto deleteProject(long projectId) {
        Project projectToDelete= projectRepository.findById(projectId).get();
        projectRepository.deleteById(projectId);
        return objectMapper.convertValue(projectToDelete,ProjectDto.class);
    }

    @Override
    public ProjectDto findProject(long projectId) {
        Project projectToSearch= projectRepository.findById(projectId).get();//.orElseThrow(IdNotFoundException::new);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        return objectMapper.convertValue(projectToSearch,ProjectDto.class);
    }

    @Override
    public List<ProjectDto> addAllProject(List<ProjectDto> projectDtos)
    {
        List<Project> projectList= Arrays.asList(objectMapper.convertValue(projectDtos,Project[].class));
        projectRepository.saveAll(projectList);
        return Arrays.asList(objectMapper.convertValue(projectDtos,ProjectDto[].class));
    }

    @Override
    public List<ProjectDto> findAllProject() {
        List<Project> libraryMemberList= projectRepository.findAll();
        return Arrays.asList(objectMapper.convertValue(libraryMemberList,ProjectDto[].class));
    }
}
