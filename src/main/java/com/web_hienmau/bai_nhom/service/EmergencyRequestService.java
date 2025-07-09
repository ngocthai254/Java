package com.web_hienmau.bai_nhom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_hienmau.bai_nhom.model.EmergencyBloodRequest;
import com.web_hienmau.bai_nhom.repositories.IEmergencyRequestRepository;

@Service
public class EmergencyRequestService {

    private final IEmergencyRequestRepository requestRepository;

    @Autowired
    public EmergencyRequestService(IEmergencyRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public EmergencyBloodRequest saveRequest(EmergencyBloodRequest request) {
        return requestRepository.save(request);
    }
}
