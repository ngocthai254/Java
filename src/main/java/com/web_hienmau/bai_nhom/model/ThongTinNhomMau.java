package com.web_hienmau.bai_nhom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "thong_tin_nhom_mau")
public class ThongTinNhomMau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ten_nhom_mau", nullable = false)
    private String tenNhomMau;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "tuong_thich_cho")
    private String tuongThichCho;

    @Column(name = "tuong_thich_nhan")
    private String tuongThichNhan;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTenNhomMau() { return tenNhomMau; }
    public void setTenNhomMau(String tenNhomMau) { this.tenNhomMau = tenNhomMau; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public String getTuongThichCho() { return tuongThichCho; }
    public void setTuongThichCho(String tuongThichCho) { this.tuongThichCho = tuongThichCho; }

    public String getTuongThichNhan() { return tuongThichNhan; }
    public void setTuongThichNhan(String tuongThichNhan) { this.tuongThichNhan = tuongThichNhan; }
}
