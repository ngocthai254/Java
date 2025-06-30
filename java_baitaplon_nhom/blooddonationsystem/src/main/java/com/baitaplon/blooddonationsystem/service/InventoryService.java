package com.baitaplon.blooddonationsystem.service;
import com.baitaplon.blooddonationsystem.dto.BloodRequestDto;

import java.util.List;
public class InventoryService {
    List<BloodRequestDto> findByBloodType(String bloodType);
    List<BloodRequestDto> findByComponentAndBloodType(String component, String bloodType);
}
