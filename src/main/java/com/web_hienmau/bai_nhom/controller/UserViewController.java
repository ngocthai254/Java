package com.web_hienmau.bai_nhom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class UserViewController {

    @GetMapping("/user/request-blood") // Đường dẫn mà người dùng sẽ truy cập
    public String showRequestBloodPage() {
        // Trả về tên của template. Thymeleaf sẽ tìm trong src/main/resources/templates/user/request_blood.html
        return "user/request_blood";
    }

    // Nếu bạn có trang chủ hoặc các trang tĩnh khác cho người dùng, bạn có thể thêm vào đây
    @GetMapping("/")
    public String homePage() {
        return "home"; // Giả sử bạn có src/main/resources/templates/home.html
    }
}