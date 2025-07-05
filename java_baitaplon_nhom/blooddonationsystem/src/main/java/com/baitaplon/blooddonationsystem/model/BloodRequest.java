package com.baitaplon.blooddonationsystem.model;

import jakarta.persistence.*;

@Entity
public class BloodRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bloodType;
    private int quantity;
    private String status;
}
