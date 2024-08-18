package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.LocationProject; 
import com.api.service.LocationProjectServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocationProjectController {

    @Autowired
    private LocationProjectServiceImpl locationProjectService;

    @PostMapping("/locationProject")
    public LocationProject saveLocationProject(@RequestBody LocationProject locationProject) {
        return locationProjectService.saveLocationProject(locationProject);
    }

    @GetMapping("/locationProject")
    public List<LocationProject> getAllLocationProject() {
        return locationProjectService.fetchAllLocationProjects();
    }
    
    @GetMapping("/locationProject/{id}")
    public LocationProject getLocationProjectById(@PathVariable("id") int id){
        return locationProjectService.getLocationProjectById(id);
    }

    @PutMapping("locationProject/{id}")
    public LocationProject updateLocationProject(@PathVariable("id") int id, @RequestBody LocationProject locationProject) {
        return locationProjectService.updateLocationProjectById(id, locationProject);
    }

    @DeleteMapping("/locationProject/{id}")
    public String deleteLocationProject(@PathVariable("id") int id){
        return locationProjectService.deleteLocationProjectById(id);
    }
    
}
