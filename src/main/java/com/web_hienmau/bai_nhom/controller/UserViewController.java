package com.web_hienmau.bai_nhom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class UserViewController {

    @GetMapping("/user/request-blood") 
    public String showRequestBloodPage() {
        
        return "user/request_blood";
    }

    @GetMapping("/")
    public String homePage() {
        return "home"; 
    }
}