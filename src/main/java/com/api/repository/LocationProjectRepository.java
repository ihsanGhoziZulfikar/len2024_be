package com.api.repository;

import org.springframework.stereotype.Repository;

import com.api.entity.LocationProject;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LocationProjectRepository extends JpaRepository<LocationProject, Integer>{
    
}
