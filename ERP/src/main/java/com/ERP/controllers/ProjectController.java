package com.ERP.controllers;

import com.ERP.dtos.ProjectDto;
import com.ERP.exceptions.IdNotFoundException;
import com.ERP.services.ProjectService;
import com.ERP.utils.MyResponseGenerator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController
{
    ProjectService projectService;

    public ProjectController(ProjectService projectService)
    {
        this.projectService=projectService;
    }
    @PostMapping("/add")
    public ResponseEntity<Object> addProject(@Valid @RequestBody ProjectDto projectDto)
    {
        ProjectDto newProject=projectService.addProject(projectDto);
        if(projectDto!=null)
        {
            return MyResponseGenerator.generateResponse(HttpStatus.CREATED,true,"Project is added",newProject);
        }
        else
        {
            return MyResponseGenerator.generateResponse(HttpStatus.BAD_REQUEST,false,"Something went wrong",newProject);
        }
    }

    @PutMapping("/update/{projectId}")
    public ResponseEntity<Object> updateProject(@Valid @RequestBody ProjectDto projectDto,@PathVariable Long projectId)
    {
        ProjectDto projectDto1= projectService.updateProject(projectDto,projectId);
        if(projectDto1!=null)
        {
            return MyResponseGenerator.generateResponse(HttpStatus.OK,true,"Project is updated successfully", projectDto1);
        }
        else {
            return MyResponseGenerator.generateResponse(HttpStatus.BAD_REQUEST,false,"Something went wrong and Project is not updated successfully",projectDto1);
        }
    }

    @GetMapping("/find/{projectId}")
    public ResponseEntity<Object> findProject(@PathVariable long projectId)
    {
        ProjectDto projectTofind =projectService.findProject(projectId);
        if(projectTofind!=null)
        {
            return MyResponseGenerator.generateResponse(HttpStatus.OK,true,"Project is found", projectTofind);
        }
        else {
            return MyResponseGenerator.generateResponse(HttpStatus.NOT_FOUND,false,"Project is not founc",projectTofind);
        }
    }

    @PostMapping("/addAll")
    public List<ProjectDto> addAll(@Valid @RequestBody List<ProjectDto> projectDtos)
    {
        return projectService.addAllProject(projectDtos);
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<Object> deleteProject(@PathVariable long projectId)
    {
        ProjectDto projectDto= projectService.deleteProject(projectId);
        if(projectDto!=null)
        {
            return MyResponseGenerator.generateResponse(HttpStatus.OK,true,"Project is Deleted Successfully",projectDto);
        }
        else {
            return MyResponseGenerator.generateResponse(HttpStatus.BAD_REQUEST,false,"Project is not Deleted Successfully",projectDto);
        }
    }
    @GetMapping("/findAll")
    public List<ProjectDto> findAll()
    {
        return projectService.findAllProject();
    }
}
