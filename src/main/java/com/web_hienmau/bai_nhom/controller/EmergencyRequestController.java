package com.web_hienmau.bai_nhom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web_hienmau.bai_nhom.model.EmergencyBloodRequest;
import com.web_hienmau.bai_nhom.service.EmergencyRequestService;

@Controller
@RequestMapping("/emergency")
public class EmergencyRequestController {

    @Autowired
    private EmergencyRequestService emergencyRequestService;

    @GetMapping("/form")
    public String showRequestForm(Model model) {
        model.addAttribute("request", new EmergencyBloodRequest());
        return "emergency/requestForm"; // trỏ đến requestForm.html trong /templates/emergency/
    }

    @PostMapping("/submit")
    public String submitRequest(@ModelAttribute("request") EmergencyBloodRequest request,
                                RedirectAttributes redirectAttributes) {
        try {
            emergencyRequestService.saveRequest(request);
            redirectAttributes.addFlashAttribute("message", "Gửi yêu cầu thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Lỗi: " + e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        return "redirect:/emergency/form";
    }
}
