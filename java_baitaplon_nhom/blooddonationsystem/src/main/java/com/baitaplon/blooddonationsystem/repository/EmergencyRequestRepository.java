package com.baitaplon.blooddonationsystem.repository;

import com.baitaplon.blooddonationsystem.model.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRequestRepository extends JpaRepository<EmergencyRequest, Long> {}
