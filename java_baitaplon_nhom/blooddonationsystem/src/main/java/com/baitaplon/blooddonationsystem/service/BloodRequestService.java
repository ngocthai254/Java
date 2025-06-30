package com.baitaplon.blooddonationsystem.service;

import com.baitaplon.blooddonationsystem.dto.BloodRequestDto;

import java.util.List;

public interface BloodRequestService {
    BloodRequestDto createRequest(BloodRequestDto dto);
    List<BloodRequestDto> getPendingRequests();
    BloodRequestDto approveRequest(Long id);
    BloodRequestDto markAsCompleted(Long id);
    void autoMatchBloodUnit(Long requestId);
}
