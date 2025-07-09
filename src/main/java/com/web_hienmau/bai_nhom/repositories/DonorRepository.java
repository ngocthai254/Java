package com.web_hienmau.bai_nhom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web_hienmau.bai_nhom.model.Donor;
import java.util.Optional;
public interface DonorRepository extends JpaRepository<Donor, Long> {
    List<Donor> findByApproved(boolean approved);
    Optional<Donor> findByPhone(String phone);
}