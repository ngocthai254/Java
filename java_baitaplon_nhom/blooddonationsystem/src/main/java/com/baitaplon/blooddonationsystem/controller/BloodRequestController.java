package com.baitaplon.blooddonationsystem.controller;

import com.baitaplon.blooddonationsystem.dto.BloodRequestDto;
import com.baitaplon.blooddonationsystem.service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class BloodRequestController {

    @Autowired
    private BloodRequestService bloodRequestService;

    // Tạo mới yêu cầu máu
    @PostMapping
    public ResponseEntity<BloodRequestDto> createBloodRequest(@RequestBody BloodRequestDto requestDto) {
        BloodRequestDto createdRequest = bloodRequestService.createRequest(requestDto);
        return ResponseEntity.ok(createdRequest);
    }

    // Lấy danh sách yêu cầu máu đang chờ xử lý
    @GetMapping("/pending")
    public ResponseEntity<List<BloodRequestDto>> getPendingRequests() {
        return ResponseEntity.ok(bloodRequestService.getPendingRequests());
    }

    // Duyệt yêu cầu máu
    @PutMapping("/{id}/approve")
    public ResponseEntity<BloodRequestDto> approveRequest(@PathVariable Long id) {
        BloodRequestDto approvedRequest = bloodRequestService.approveRequest(id);
        return ResponseEntity.ok(approvedRequest);
    }
}
