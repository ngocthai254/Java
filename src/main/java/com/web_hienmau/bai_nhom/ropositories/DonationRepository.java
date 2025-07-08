package com.web_hienmau.bai_nhom.ropositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web_hienmau.bai_nhom.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByDonorId(Long donorId);
}