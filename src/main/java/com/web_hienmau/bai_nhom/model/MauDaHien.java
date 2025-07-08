package com.web_hienmau.bai_nhom.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mau_da_hien")
public class MauDaHien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "full_name")
    private String fullName;

    private String gender;
    private String note;
    private String phone;

    private int quantity; 

    @Column(name = "request_date")
    private LocalDateTime requestDate;

    private String status;

    public MauDaHien() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDateTime getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDateTime requestDate) { this.requestDate = requestDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
