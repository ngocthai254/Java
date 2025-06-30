package com.baitaplon.blooddonationsystem.service.impl;

import com.baitaplon.blooddonationsystem.dto.UserDto;
import com.baitaplon.blooddonationsystem.model.User;
import com.baitaplon.blooddonationsystem.repository.UserRepository;
import com.baitaplon.blooddonationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> findNearbyDonors(double lat, double lon, double radiusKm) {
        List<User> members = userRepository.findByRole("MEMBER");

        return members.stream()
                .filter(user -> user.getLatitude() != null && user.getLongitude() != null)
                .filter(user -> calculateDistance(lat, lon, user.getLatitude(), user.getLongitude()) <= radiusKm)
                .map(user -> new UserDto(user.getId(), user.getName(), user.getBloodType(), user.getLatitude(), user.getLongitude()))
                .collect(Collectors.toList());
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
