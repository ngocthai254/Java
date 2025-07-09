package com.web_hienmau.bai_nhom.controller;

import com.web_hienmau.bai_nhom.model.BloodRequest;
import com.web_hienmau.bai_nhom.service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/blood-requests") 
@CrossOrigin(origins = "*") 
public class BloodRequestController {

    @Autowired
    private BloodRequestService service;

    @PostMapping
    public BloodRequest create(@RequestBody BloodRequest request) {
        return service.save(request);
    }
    @GetMapping
    public List<BloodRequest> getAll() {
        return service.findAll();
    }
}
