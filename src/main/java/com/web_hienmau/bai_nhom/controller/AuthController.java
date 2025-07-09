package com.web_hienmau.bai_nhom.controller;

import com.web_hienmau.bai_nhom.model.Userclass;
import com.web_hienmau.bai_nhom.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new Userclass());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") Userclass user, Model model) {
        if (userRepository.existsBySoDienThoai(user.getSoDienThoai())) {
            model.addAttribute("error", "Số điện thoại đã được đăng ký!");
            return "register";
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "Email đã được đăng ký!");
            return "register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
