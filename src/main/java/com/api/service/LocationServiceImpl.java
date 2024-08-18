package com.api.service;

import java.util.List;
import java.util.Optional;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.Location;
import com.api.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

    public LocationServiceImpl(){

    }

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location saveLocation(Location location){
        return locationRepository.save(location);
    }

    @Override
    public List<Location> fetchAllLocations(){
        List<Location> allLocations = locationRepository.findAll();
        return allLocations;
    }

    @Override
    public Location getLocationById(int id){
        Optional<Location> location = locationRepository.findById(id);
        if(location.isPresent()){
            return location.get();
        }
        // Location p = new Location(0, "lokasi not found", "client 1", "pimpinan 1", "keterangan 1", LocalDateTime.now());
        return null;
    }
    @Override
    public Location updateLocationById(int id, Location location){
        Optional<Location> location1 = locationRepository.findById(id);

        if(location1.isPresent()){
            Location originalLocation = location1.get();

            if(Objects.nonNull(location.getNamaLokasi()) && !"".equalsIgnoreCase(location.getNamaLokasi())){
                originalLocation.setNamaLokasi(location.getNamaLokasi());
            }
            
            if(Objects.nonNull(location.getNegara()) && !"".equalsIgnoreCase(location.getNegara())){
                originalLocation.setNegara(location.getNegara());
            }
            
            if(Objects.nonNull(location.getProvinsi()) && !"".equalsIgnoreCase(location.getProvinsi())){
                originalLocation.setProvinsi(location.getProvinsi());
            }
            
            if(Objects.nonNull(location.getKota()) && !"".equalsIgnoreCase(location.getKota())){
                originalLocation.setKota(location.getKota());
            }
            
            if(Objects.nonNull(location.getCreatedAt())){
                originalLocation.setCreatedAt(location.getCreatedAt());
            }
            
            return locationRepository.save(originalLocation);
        }
        return null;
    }

    @Override
    public String deleteLocationById(int id){
        if(locationRepository.findById(id).isPresent()){
            locationRepository.deleteById(id);
            return "Location deleted successfully";
        }
        return "No such location in the database";
    }
}
