package com.baitaplon.blooddonationsystem.service;
import com.baitaplon.blooddonationsystem.dto.UserDto;
import java.util.List;
public class UserService {
    
    List<UserDto> findNearbyDonors(double latitude, double longitude, double radiusKm);
}
