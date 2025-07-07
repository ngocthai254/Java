package com.web_hienmau.bai_nhom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "loi_ich_hien_mau")
public class LoiIchHienMau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tieu_de_loi_ich", nullable = false)
    private String tieuDeLoiIch;

    @Column(name = "mo_ta_loi_ich", columnDefinition = "TEXT")
    private String moTaLoiIch;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTieuDeLoiIch() { return tieuDeLoiIch; }
    public void setTieuDeLoiIch(String tieuDeLoiIch) { this.tieuDeLoiIch = tieuDeLoiIch; }

    public String getMoTaLoiIch() { return moTaLoiIch; }
    public void setMoTaLoiIch(String moTaLoiIch) { this.moTaLoiIch = moTaLoiIch; }
}
