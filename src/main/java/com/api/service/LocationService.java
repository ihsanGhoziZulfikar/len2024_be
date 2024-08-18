package com.api.service;

import java.util.List;

import com.api.entity.Location;

public interface LocationService {
    Location saveLocation(Location location);

    List<Location> fetchAllLocations();

    Location getLocationById(int id);

    Location updateLocationById(int id, Location location);

    String deleteLocationById(int id);
}
