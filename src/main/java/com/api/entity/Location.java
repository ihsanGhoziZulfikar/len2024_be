package com.api.entity;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lokasi")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nama_lokasi")
    private String namaLokasi;
    
    @Column(name = "negara")
    private String negara;
    
    @Column(name = "provinsi")
    private String provinsi;
    
    @Column(name = "kota")
    private String kota;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "lokasi")
    @JsonManagedReference(value = "location-project")
    private Set<LocationProject> lokasiProyek;

    public Location(){

    }

    public Location(int id, String namaLokasi, String negara, String provinsi, String kota, LocalDateTime createdAt) {
        this.id = id;
        this.namaLokasi = namaLokasi;
        this.negara = negara;
        this.provinsi = provinsi;
        this.kota = kota;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }
    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }
    public String getNegara() {
        return negara;
    }
    public void setNegara(String negara) {
        this.negara = negara;
    }
    public String getProvinsi() {
        return provinsi;
    }
    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
    public String getKota() {
        return kota;
    }
    public void setKota(String kota) {
        this.kota = kota;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public Set<LocationProject> getLokasiProyek() {
        return lokasiProyek;
    }

    public void setLokasiProyek(Set<LocationProject> lokasiProyek) {
        this.lokasiProyek = lokasiProyek;
    }

}
