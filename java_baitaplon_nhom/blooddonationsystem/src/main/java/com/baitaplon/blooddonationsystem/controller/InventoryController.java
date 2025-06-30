package com.baitaplon.blooddonationsystem.controller;


import com.baitaplon.blooddonationsystem.dto.BloodRequestDto;
import com.baitaplon.blooddonationsystem.dto.UserDto;
import com.baitaplon.blooddonationsystem.service.InventoryService;
import com.baitaplon.blooddonationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private UserService userService;

    // 🔍 1. Tìm máu theo nhóm máu
    @GetMapping("/search/by-blood-type")
    public ResponseEntity<List<BloodRequestDto>> findByBloodType(@RequestParam String bloodType) {
        return ResponseEntity.ok(inventoryService.findByBloodType(bloodType));
    }

    // 💉 2. Tìm máu theo thành phần + nhóm máu
    @GetMapping("/search/by-component")
    public ResponseEntity<List<BloodRequestDto>> findByComponentAndBloodType(@RequestParam String component, @RequestParam String bloodType) {
        return ResponseEntity.ok(inventoryService.findByComponentAndBloodType(component, bloodType));
    }

    // 📍 3. Tìm người hiến máu gần bạn
    @GetMapping("/donors/nearby")
    public ResponseEntity<List<UserDto>> findNearbyDonors(@RequestParam double latitude, @RequestParam double longitude, @RequestParam(defaultValue = "10") double radiusKm) {
        return ResponseEntity.ok(userService.findNearbyDonors(latitude, longitude, radiusKm));
    }
}


    @GetMapping("/search/form")
    public String showSearchForm(Model model) {
        model.addAttribute("units", Collections.emptyList());
        return "find_blood";
    }

    @GetMapping("/donors/map/view")
    public String showNearbyDonorMap(Model model) {
        List<UserDto> donors = userService.findNearbyDonors( /* Có thể lấy từ request params hoặc địa chỉ IP */ );
        model.addAttribute("donors", donors);
        return "nearby_donors";
    }
