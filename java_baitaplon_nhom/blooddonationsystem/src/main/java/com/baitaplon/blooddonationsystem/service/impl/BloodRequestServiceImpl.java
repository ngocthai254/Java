package com.baitaplon.blooddonationsystem.service.impl;

import com.baitaplon.blooddonationsystem.dto.BloodRequestDto;
import com.baitaplon.blooddonationsystem.model.BloodRequest;
import com.baitaplon.blooddonationsystem.model.BloodUnit;
import com.baitaplon.blooddonationsystem.repository.BloodRequestRepository;
import com.baitaplon.blooddonationsystem.repository.BloodUnitRepository;
import com.baitaplon.blooddonationsystem.repository.EmergencyRequestRepository;
import com.baitaplon.blooddonationsystem.service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BloodRequestServiceImpl implements BloodRequestService {
    @Autowired
    private EmergencyRequestRepository emergencyRequestRepository;

    @Autowired
    private BloodRequestRepository bloodRequestRepository;

    @Autowired
    private BloodUnitRepository bloodUnitRepository;

    @Override
    public BloodRequestDto createRequest(BloodRequestDto dto) {
        BloodRequest request = new BloodRequest();
        request.setBloodType(dto.getBloodType());
        request.setQuantity(dto.getQuantity());
        request.setStatus("PENDING");
        bloodRequestRepository.save(request);
        return dto;
    }

    @Override
    public List<BloodRequestDto> getPendingRequests() {
        return bloodRequestRepository.findByStatus("PENDING").stream()
                .map(req -> new BloodRequestDto(req.getId(), req.getBloodType(), req.getQuantity(), req.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public BloodRequestDto approveRequest(Long id) {
        Optional<BloodRequest> optional = bloodRequestRepository.findById(id);
        if (optional.isPresent()) {
            BloodRequest request = optional.get();
            request.setStatus("APPROVED");
            bloodRequestRepository.save(request);

            autoMatchBloodUnit(request.getId());
            return new BloodRequestDto(request.getId(), request.getBloodType(), request.getQuantity(), request.getStatus());
        }
        throw new RuntimeException("Request not found");
    }

    @Override
    public BloodRequestDto markAsCompleted(Long id) {
        Optional<BloodRequest> optional = bloodRequestRepository.findById(id);
        if (optional.isPresent()) {
            BloodRequest request = optional.get();
            request.setStatus("COMPLETED");
            bloodRequestRepository.save(request);
            return new BloodRequestDto(request.getId(), request.getBloodType(), request.getQuantity(), request.getStatus());
        }
        throw new RuntimeException("Request not found");
    }

    @Override
    public void autoMatchBloodUnit(Long requestId) {
        BloodRequest request = bloodRequestRepository.findById(requestId).orElseThrow();
        List<BloodUnit> units = bloodUnitRepository.findByBloodTypeAndAvailableTrue(request.getBloodType());

        int needed = request.getQuantity();
        for (BloodUnit unit : units) {
            if (needed <= 0) break;
            unit.setAvailable(false);
            bloodUnitRepository.save(unit);
            needed--;
        }

        if (needed > 0) {
            // Gửi thông báo cho người hiến máu (chức năng có thể tích hợp với NotificationService)
            System.out.println("Chưa đủ máu, gửi thông báo hiến máu khẩn cấp!");
        }
    }
}
