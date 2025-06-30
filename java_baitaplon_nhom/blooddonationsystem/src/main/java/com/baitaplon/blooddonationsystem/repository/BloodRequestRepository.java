package com.baitaplon.blooddonationsystem.repository;

import com.baitaplon.blooddonationsystem.model.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {
    List<BloodRequest> findByStatus(String status);
}
