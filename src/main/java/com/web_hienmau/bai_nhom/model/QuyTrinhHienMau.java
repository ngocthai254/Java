package com.web_hienmau.bai_nhom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quy_trinh_hien_mau")
public class QuyTrinhHienMau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "so_buoc")
    private int soBuoc;

    @Column(name = "tieu_de_buoc", nullable = false)
    private String tieuDeBuoc;

    @Column(name = "mo_ta_buoc", columnDefinition = "TEXT")
    private String moTaBuoc;

    @Column(name = "thoi_gian_uoc_tinh_phut")
    private Integer thoiGianUocTinhPhut;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getSoBuoc() { return soBuoc; }
    public void setSoBuoc(int soBuoc) { this.soBuoc = soBuoc; }

    public String getTieuDeBuoc() { return tieuDeBuoc; }
    public void setTieuDeBuoc(String tieuDeBuoc) { this.tieuDeBuoc = tieuDeBuoc; }

    public String getMoTaBuoc() { return moTaBuoc; }
    public void setMoTaBuoc(String moTaBuoc) { this.moTaBuoc = moTaBuoc; }

    public Integer getThoiGianUocTinhPhut() { return thoiGianUocTinhPhut; }
    public void setThoiGianUocTinhPhut(Integer thoiGianUocTinhPhut) { this.thoiGianUocTinhPhut = thoiGianUocTinhPhut; }
}
