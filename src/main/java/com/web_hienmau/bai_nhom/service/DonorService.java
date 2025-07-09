package com.web_hienmau.bai_nhom.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_hienmau.bai_nhom.model.BloodRequest;
import com.web_hienmau.bai_nhom.model.Donation;
import com.web_hienmau.bai_nhom.model.Donor;
import com.web_hienmau.bai_nhom.repositories.DonationRepository;
import com.web_hienmau.bai_nhom.repositories.DonorRepository;
import com.web_hienmau.bai_nhom.repositories.IBloodRequestRepository;

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
    // Tạo bản ghi yêu cầu hiến máu như một bản ghi Donation tạm thời
        Donation donation = new Donation();
        donation.setDonor(donor);
        donation.setDonationDate(LocalDate.now());
        donation.setQuantity(0); // Chưa hiến nên đặt 0
        donation.setLocation("Chưa xác định");
        donation.setStatus("REQUESTED"); // Trạng thái yêu cầu
        donationRepository.save(donation);

        // In log (hoặc có thể gửi email thực tế nếu tích hợp mail)
        System.out.println("[Gửi yêu cầu] " + donor.getEmail() + ": " + message);
    }


    public List<BloodRequest> getPendingBloodRequests() {
        return bloodRequestRepo.findAll()
                .stream()
                .filter(req -> req.getStatus().equalsIgnoreCase("PENDING"))
                .toList();
    }

    public void approveRequestToDonor(Long requestId) {
        Optional<BloodRequest> optReq = bloodRequestRepo.findById(requestId);
        if (optReq.isEmpty()) return;

        BloodRequest req = optReq.get();

        Optional<Donor> existing = donorRepository.findByPhone(req.getPhone());
        if (existing.isPresent()) {
            req.setStatus("APPROVED");
            bloodRequestRepo.save(req);
            return; 
        }

        Donor donor = new Donor();
        donor.setFullName(req.getFullName());
        donor.setGender(req.getGender());
        donor.setBloodGroup(req.getBloodGroup());
        donor.setPhone(req.getPhone());
        donor.setEmail(req.getEmail() != null ? req.getEmail() : "");
        donor.setAddress("Chưa cập nhật");
        donor.setBirthDate(LocalDate.of(2000, 1, 1));
        donor.setApproved(true);
        donorRepository.save(donor);

        // Cập nhật trạng thái yêu cầu
        req.setStatus("APPROVED");
        bloodRequestRepo.save(req);
    }
}
