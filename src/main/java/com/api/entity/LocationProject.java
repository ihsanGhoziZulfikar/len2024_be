package com.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lokasi_proyek")
public class LocationProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "proyek_id")
    @JsonBackReference(value = "project-location")
    private Project proyek;

    @ManyToOne
    @JoinColumn(name = "lokasi_id")
    @JsonBackReference(value = "location-project")
    private Location lokasi;


    public LocationProject() {
    }
    
    public LocationProject(Integer id, Project proyek, Location lokasi) {
        this.id = id;
        this.proyek = proyek;
        this.lokasi = lokasi;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProyek() {
        return proyek;
    }

    public void setProyek(Project proyek) {
        this.proyek = proyek;
    }

    public Location getLokasi() {
        return lokasi;
    }

    public void setLokasi(Location lokasi) {
        this.lokasi = lokasi;
    }

    @JsonProperty("namaLokasi")
    public String getNamaLokasi() {
        return lokasi.getNamaLokasi();
    }

    @JsonProperty("namaProyek")
    public String getNamaProyek() {
        return proyek.getNamaProyek();
    }
    
}