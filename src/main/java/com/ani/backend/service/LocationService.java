package com.ani.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ani.backend.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<String> getLocations() {
        return locationRepository.retrieveLocationsFromDatabase();
    }
}
