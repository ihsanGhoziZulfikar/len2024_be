package com.api.repository;

import org.springframework.stereotype.Repository;

import com.api.entity.Location;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
    
}
