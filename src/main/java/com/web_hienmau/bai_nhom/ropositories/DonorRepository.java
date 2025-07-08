package com.web_hienmau.bai_nhom.ropositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web_hienmau.bai_nhom.model.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {
    List<Donor> findByApproved(boolean approved);
}