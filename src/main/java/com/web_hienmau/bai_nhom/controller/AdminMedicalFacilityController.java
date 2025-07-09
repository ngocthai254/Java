package com.web_hienmau.bai_nhom.controller;

import com.web_hienmau.bai_nhom.model.MedicalFacility;
import com.web_hienmau.bai_nhom.service.MedicalFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/facilities")
public class AdminMedicalFacilityController {

    private final MedicalFacilityService facilityService;

    @Autowired
    public AdminMedicalFacilityController(MedicalFacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping("")
    public String listFacilities(Model model) {
        List<MedicalFacility> facilities = facilityService.getAllFacilities();
        model.addAttribute("facilities", facilities);
        return "admin/facilities"; 
    }
}
