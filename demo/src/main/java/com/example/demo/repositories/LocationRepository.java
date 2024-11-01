package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByCity(String city);
}
