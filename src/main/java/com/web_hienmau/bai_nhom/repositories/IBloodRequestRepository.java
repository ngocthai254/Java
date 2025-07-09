package com.web_hienmau.bai_nhom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web_hienmau.bai_nhom.model.BloodRequest;

public interface IBloodRequestRepository extends JpaRepository<BloodRequest, Long> {

}