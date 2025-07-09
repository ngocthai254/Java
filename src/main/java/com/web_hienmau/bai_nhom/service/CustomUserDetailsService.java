package com.web_hienmau.bai_nhom.service;

import com.web_hienmau.bai_nhom.model.CustomUserDetails;
import com.web_hienmau.bai_nhom.model.Userclass;
import com.web_hienmau.bai_nhom.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Userclass user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Không tìm thấy người dùng với email: " + email);
        }
        return new CustomUserDetails(user);
    }
}
