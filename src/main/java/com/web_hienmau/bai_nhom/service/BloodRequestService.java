package com.web_hienmau.bai_nhom.service;

import com.web_hienmau.bai_nhom.model.BloodRequest;
import com.web_hienmau.bai_nhom.ropositories.IBloodRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
