package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NewUser;

@Repository 
public interface UserRepository extends JpaRepository<NewUser, Long> {
    List<NewUser> findByUsername(String name);
    List<NewUser> findByEmail(String email);
    List<NewUser> findByPassword(String pass);
}
