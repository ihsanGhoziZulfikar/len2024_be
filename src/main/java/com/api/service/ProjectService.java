package com.api.service;

import java.util.List;

import com.api.entity.Project;

public interface ProjectService {
    Project saveProject(Project project);

    List<Project> fetchAllProjects();

    Project getProjectById(int id);

    Project updateProjectById(int id, Project project);

    String deleteProjectById(int id);
}
