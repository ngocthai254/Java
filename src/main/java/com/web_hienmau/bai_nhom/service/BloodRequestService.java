package com.web_hienmau.bai_nhom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_hienmau.bai_nhom.model.BloodRequest;
import com.web_hienmau.bai_nhom.repositories.IBloodRequestRepository;

@Service
public class BloodRequestService {

    @Autowired
    private IBloodRequestRepository repository;

    public BloodRequest save(BloodRequest request) {
        return repository.save(request);
    }

    public List<BloodRequest> findAll() {
        return repository.findAll();
    }

    // ✅ Hàm này dùng để tìm theo ID (dùng trong controller)
    public Optional<BloodRequest> findById(Long id) {
        return repository.findById(id);
    }
}
