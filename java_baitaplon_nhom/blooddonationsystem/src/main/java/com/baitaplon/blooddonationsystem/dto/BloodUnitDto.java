package com.baitaplon.blooddonationsystem.dto;
import java.time.LocalDate;
public class BloodUnitDto {

    private Long id;
    private String bloodType;
    private String component; // Ví dụ: "Hồng cầu", "Huyết tương", "Tiểu cầu"
    private boolean available;
    private LocalDate expirationDate;

    public BloodUnitDto() {}

    public BloodUnitDto(Long id, String bloodType, String component, LocalDate expirationDate) {
        this.id = id;
        this.bloodType = bloodType;
        this.component = component;
        this.expirationDate = expirationDate;
        this.available = true;
    }

    // Getters và Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBloodType() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    public String getComponent() { return component; }
    public void setComponent(String component) { this.component = component; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public LocalDate getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }
}

