package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CityDto;
import com.example.demo.dto.LocationDto;
import com.example.demo.model.Location;
import com.example.demo.repositories.LocationRepository;

@RestController
@RequestMapping("/cities")
public class CitiesIndex {

    @Autowired
    LocationRepository repo;

    @GetMapping("/all")
    public ResponseEntity<List<LocationDto>> findAllLocations(){
        List<LocationDto> locations = repo.findAll()
        .stream()
        .map(location -> new LocationDto(location.getCountry(), location.getState(), location.getCity()))
        .collect(Collectors.toList());

        if (locations.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/{query}")
    public ResponseEntity<List<Location>> findQueriedCity(String query){
        List<Location> location = repo.findByCity(query); 

        if(location.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> findAllCities(){
        List<CityDto> cities = repo.findAll()
        .stream()
        .map(location -> new CityDto(location.getId(), location.getCity()))
        .collect(Collectors.toList());

        if(cities.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
    @GetMapping("/start/{city}")
    public ResponseEntity<List<CityDto>> findCityStartingWith(@PathVariable String city){
        List<CityDto> cities = repo.findByCityStartingWith(city)
        .stream()
        .map(location -> new CityDto(location.getId(), location.getCity()))
        .collect(Collectors.toList());

        if(cities.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
    
}
