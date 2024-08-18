package com.api.service;

import java.util.List;
import java.util.Optional;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.LocationProject;
import com.api.repository.LocationProjectRepository;

@Service
public class LocationProjectServiceImpl implements LocationProjectService {

    public LocationProjectServiceImpl(){

    }

    @Autowired
    private LocationProjectRepository locationProjectRepository;

    @Override
    public LocationProject saveLocationProject(LocationProject locationProject){
        return locationProjectRepository.save(locationProject);
    }

    @Override
    public List<LocationProject> fetchAllLocationProjects(){
        List<LocationProject> allLocationProjects = locationProjectRepository.findAll();
        return allLocationProjects;
    }

    @Override
    public LocationProject getLocationProjectById(int id){
        Optional<LocationProject> locationProject = locationProjectRepository.findById(id);
        if(locationProject.isPresent()){
            return locationProject.get();
        }
        // LocationProject p = new LocationProject(0, "lokasi not found", "client 1", "pimpinan 1", "keterangan 1", LocalDateTime.now());
        return null;
    }
    @Override
    public LocationProject updateLocationProjectById(int id, LocationProject locationProject){
        Optional<LocationProject> locationProject1 = locationProjectRepository.findById(id);

        if(locationProject1.isPresent()){
            LocationProject originalLocationProject = locationProject1.get();

            if(Objects.nonNull(locationProject.getProyek())){
                originalLocationProject.setProyek(locationProject.getProyek());
            }
            
            if(Objects.nonNull(locationProject.getLokasi())){
                originalLocationProject.setLokasi(locationProject.getLokasi());
            }
            
            return locationProjectRepository.save(originalLocationProject);
        }
        return null;
    }

    @Override
    public String deleteLocationProjectById(int id){
        if(locationProjectRepository.findById(id).isPresent()){
            locationProjectRepository.deleteById(id);
            return "LocationProject deleted successfully";
        }
        return "No such locationProject in the database";
    }
}

