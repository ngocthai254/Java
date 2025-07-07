package com.web_hienmau.bai_nhom.controller;

import com.web_hienmau.bai_nhom.model.BloodRequest;
import com.web_hienmau.bai_nhom.service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/blood-requests") // Đã thay đổi từ "/api/blood-requests"
@CrossOrigin(origins = "*") // Cho phép request từ form HTML
public class BloodRequestController {

    @Autowired
    private BloodRequestService service;

    // API: Lưu yêu cầu hiến máu
    @PostMapping
    public BloodRequest create(@RequestBody BloodRequest request) {
        return service.save(request);
    }

    // API: Lấy danh sách tất cả các yêu cầu
    @GetMapping
    public List<BloodRequest> getAll() {
        return service.findAll();
    }
}
