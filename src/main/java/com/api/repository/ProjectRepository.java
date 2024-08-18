package com.api.repository;

import org.springframework.stereotype.Repository;

import com.api.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
    @Query("SELECT p FROM Project p LEFT JOIN p.lokasiProyek lp LEFT JOIN lp.lokasi l WHERE p.id = :proyekId")
    Project findProyekWithLocations(@Param("proyekId") Integer proyekId);
}
