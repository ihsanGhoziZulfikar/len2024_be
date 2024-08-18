package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Project; 
import com.api.service.ProjectServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @PostMapping("/project")
    public Project saveProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @GetMapping("/project")
    public List<Project> getAllProject() {
        return projectService.fetchAllProjects();
    }
    
    @GetMapping("/project/{id}")
    public Project getProjectById(@PathVariable("id") int id){
        return projectService.getProjectById(id);
    }

    @PutMapping("project/{id}")
    public Project updateProject(@PathVariable("id") int id, @RequestBody Project project) {
        return projectService.updateProjectById(id, project);
    }

    @DeleteMapping("/project/{id}")
    public String deleteProject(@PathVariable("id") int id){
        return projectService.deleteProjectById(id);
    }
    
}
