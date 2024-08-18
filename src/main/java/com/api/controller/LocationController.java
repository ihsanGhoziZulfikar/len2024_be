package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Location; 
import com.api.service.LocationServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocationController {

    @Autowired
    private LocationServiceImpl locationService;

    @PostMapping("/location")
    public Location saveLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }

    @GetMapping("/location")
    public List<Location> getAllLocation() {
        return locationService.fetchAllLocations();
    }
    
    @GetMapping("/location/{id}")
    public Location getLocationById(@PathVariable("id") int id){
        return locationService.getLocationById(id);
    }

    @PutMapping("location/{id}")
    public Location updateLocation(@PathVariable("id") int id, @RequestBody Location location) {
        return locationService.updateLocationById(id, location);
    }

    @DeleteMapping("/location/{id}")
    public String deleteLocation(@PathVariable("id") int id){
        return locationService.deleteLocationById(id);
    }
    
}
