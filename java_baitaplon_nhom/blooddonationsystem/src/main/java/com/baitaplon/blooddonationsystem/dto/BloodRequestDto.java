package com.baitaplon.blooddonationsystem.dto;

public class BloodRequestDto {
    private Long id;
    private String bloodType;
    private int quantity;
    private String status;

    public BloodRequestDto() {}

    public BloodRequestDto(Long id, String bloodType, int quantity, String status) {
        this.id = id;
        this.bloodType = bloodType;
        this.quantity = quantity;
        this.status = status;
    }
}
