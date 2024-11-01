package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Location;


public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByCity(String city);
    List<Location> findByCityStartingWith(String city); // testa
    List<Location> findByCityContaining(String city); // testa
    List<Location> findByCityAndState(String city, String state); // testa
    List<Location> findByPropriedadeFalse(String city); // testa
}
