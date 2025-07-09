package com.baitaplon.blooddonationsystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EmergencyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bloodType;
    private int missingUnits;
    private LocalDateTime createdAt;

    // Getters & Setters
}
