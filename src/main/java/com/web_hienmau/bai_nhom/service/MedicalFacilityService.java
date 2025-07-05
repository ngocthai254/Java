package com.web_hienmau.bai_nhom.service;

import com.web_hienmau.bai_nhom.model.MedicalFacility;
import com.web_hienmau.bai_nhom.ropositories.IMedicalFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalFacilityService {

    private final IMedicalFacilityRepository repository;

    @Autowired
    public MedicalFacilityService(IMedicalFacilityRepository repository) {
        this.repository = repository;
    }

    public List<MedicalFacility> getAllFacilities() {
        return repository.findAll();
    }

    public Optional<MedicalFacility> getFacilityById(Long id) {
        return repository.findById(id);
    }

    public void saveFacility(MedicalFacility facility) {
        facility.setUpdatedAt(java.time.LocalDateTime.now());
        repository.save(facility);
    }

    public void deleteFacility(Long id) {
        repository.deleteById(id);
    }
}
