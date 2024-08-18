package com.api.service;

import java.util.List;

import com.api.entity.LocationProject;

public interface LocationProjectService {
    LocationProject saveLocationProject(LocationProject locationProject);

    List<LocationProject> fetchAllLocationProjects();

    LocationProject getLocationProjectById(int id);

    LocationProject updateLocationProjectById(int id, LocationProject locationProject);

    String deleteLocationProjectById(int id);
}
