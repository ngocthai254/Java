package com.web_hienmau.bai_nhom.ropositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web_hienmau.bai_nhom.model.EmergencyBloodRequest;

@Repository
public interface IEmergencyRequestRepository extends JpaRepository<EmergencyBloodRequest, Long> {
}
