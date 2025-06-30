package com.baitaplon.blooddonationsystem.service.impl;

import com.baitaplon.blooddonationsystem.model.User;
import com.baitaplon.blooddonationsystem.repository.UserRepository;
import com.baitaplon.blooddonationsystem.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void notifyPotentialDonors(String bloodType) {
        List<User> potentialDonors = userRepository.findByBloodTypeAndRole(bloodType, "MEMBER");
        for (User donor : potentialDonors) {
            System.out.println("Gửi thông báo tới: " + donor.getEmail() + " - Cần máu nhóm " + bloodType);
        }
    }
}
