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
@Table(name = "proyek")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nama_proyek")
    private String namaProyek;
    
    @Column(name = "client")
    private String client;
    
    @Column(name = "tgl_mulai")
    private LocalDateTime tglMulai;
    
    @Column(name = "tgl_selesai")
    private LocalDateTime tglSelesai;
    
    @Column(name = "pimpinan_proyek")
    private String pimpinanProyek;
    
    @Column(name = "keterangan")
    private String keterangan;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "proyek")
    @JsonManagedReference(value = "project-location")
    private Set<LocationProject> lokasiProyek;

    public Project() {
        
    }

    public Project(int id, String namaProyek, String client, LocalDateTime tglMulai, LocalDateTime tglSelesai, String pimpinanProyek, String keterangan, LocalDateTime createdAt){
        this.id = id;
        this.namaProyek = namaProyek;
        this.client = client;
        this.tglMulai = tglMulai;
        this.tglSelesai = tglSelesai;
        this.pimpinanProyek = pimpinanProyek;
        this.keterangan = keterangan;
        this.createdAt = createdAt;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNamaProyek() {
        return namaProyek;
    }


    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }


    public String getClient() {
        return client;
    }


    public void setClient(String client) {
        this.client = client;
    }


    public LocalDateTime getTglMulai() {
        return tglMulai;
    }


    public void setTglMulai(LocalDateTime tglMulai) {
        this.tglMulai = tglMulai;
    }


    public LocalDateTime getTglSelesai() {
        return tglSelesai;
    }


    public void setTglSelesai(LocalDateTime tglSelesai) {
        this.tglSelesai = tglSelesai;
    }


    public String getPimpinanProyek() {
        return pimpinanProyek;
    }


    public void setPimpinanProyek(String pimpinanProyek) {
        this.pimpinanProyek = pimpinanProyek;
    }


    public String getKeterangan() {
        return keterangan;
    }


    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
