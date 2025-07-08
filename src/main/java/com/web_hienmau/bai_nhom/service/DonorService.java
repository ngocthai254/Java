package com.web_hienmau.bai_nhom.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_hienmau.bai_nhom.model.BloodRequest;
import com.web_hienmau.bai_nhom.model.Donation;
import com.web_hienmau.bai_nhom.model.Donor;
import com.web_hienmau.bai_nhom.ropositories.DonationRepository;
import com.web_hienmau.bai_nhom.ropositories.DonorRepository;
import com.web_hienmau.bai_nhom.ropositories.IBloodRequestRepository;

@Service
public class DonorService {
    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private IBloodRequestRepository bloodRequestRepo;

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public List<Donor> getPendingDonors() {
        return donorRepository.findByApproved(false);
    }

    public Optional<Donor> getDonorById(Long id) {
        return donorRepository.findById(id);
    }

    public List<Donation> getDonationsByDonorId(Long donorId) {
        return donationRepository.findByDonorId(donorId);
    }

    public void saveDonation(Donation donation) {
        donationRepository.save(donation);
    }

    public void saveDonor(Donor donor) {
        donorRepository.save(donor);
    }

    public void sendBloodRequest(Donor donor, String message) {
        System.out.println("[Gửi yêu cầu] " + donor.getEmail() + ": " + message);
    }

    public List<BloodRequest> getPendingBloodRequests() {
        return bloodRequestRepo.findAll()
                .stream()
                .filter(req -> req.getStatus().equalsIgnoreCase("PENDING"))
                .toList();
    }

    public void approveRequestToDonor(Long requestId) {
        BloodRequest req = bloodRequestRepo.findById(requestId).orElse(null);
        if (req != null) {
            Donor donor = new Donor();
            donor.setFullName(req.getFullName());
            donor.setGender(req.getGender());
            donor.setBloodGroup(req.getBloodGroup());
            donor.setPhone(req.getPhone());
            donor.setEmail("");
            donor.setAddress("Chưa cập nhật");
            donor.setBirthDate(LocalDate.of(2000, 1, 1));
            donor.setApproved(true);
            donorRepository.save(donor);

            req.setStatus("APPROVED");
            bloodRequestRepo.save(req);
        }
    }
}
