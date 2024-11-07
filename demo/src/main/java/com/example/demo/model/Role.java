// package com.example.demo.model;

// import java.util.Set;
// import java.util.HashSet;
// import jakarta.persistence.*;

// @Entity
// @Table(name = "UserRole")
// public class Role {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column
//     private String name;

//     @Column
//     private Integer generationLimit;

//     @OneToMany(mappedBy = "role")
//     private Set<NewUser> users = new HashSet<>();

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public Integer getGenerationLimit() {
//         return generationLimit;
//     }

//     public void setGenerationLimit(Integer generationLimit) {
//         this.generationLimit = generationLimit;
//     }

//     public Set<NewUser> getUsers() {
//         return users;
//     }

//     public void setUsers(Set<NewUser> users) {
//         this.users = users;
//     }
// }