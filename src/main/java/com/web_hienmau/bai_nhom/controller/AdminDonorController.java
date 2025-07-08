package com.web_hienmau.bai_nhom.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web_hienmau.bai_nhom.model.Donor;
import com.web_hienmau.bai_nhom.service.DonorService;

@Controller
@RequestMapping("/admin/donors")
public class AdminDonorController {

    @Autowired
    private DonorService donorService;

    // Hiển thị tất cả người hiến
    @GetMapping("")
    public String listDonors(Model model) {
        model.addAttribute("donors", donorService.getAllDonors());
        return "admin/donors";
    }

    // Hiển thị danh sách chờ duyệt
    @GetMapping("/pending")
    public String pendingDonors(Model model) {
        model.addAttribute("donors", donorService.getPendingDonors());
        return "admin/pendingDonors";
    }

    // Duyệt người hiến máu
    @PostMapping("/approve/{id}")
    public String approveDonor(@PathVariable Long id, RedirectAttributes redirect) {
        Optional<Donor> donorOpt = donorService.getDonorById(id);
        if (donorOpt.isPresent()) {
            Donor donor = donorOpt.get();
            donor.setApproved(true);
            donorService.saveDonor(donor);
            redirect.addFlashAttribute("message", "Đã duyệt người hiến máu thành công.");
        } else {
            redirect.addFlashAttribute("message", "Không tìm thấy người hiến máu.");
        }
        return "redirect:/admin/donors/pending";
    }

    // Xem thông tin chi tiết người hiến máu
    @GetMapping("/view/{id}")
    public String viewDonor(@PathVariable Long id, Model model, RedirectAttributes redirect) {
        Optional<Donor> donorOpt = donorService.getDonorById(id);
        if (donorOpt.isEmpty()) {
            redirect.addFlashAttribute("message", "Không tìm thấy người hiến máu!");
            return "redirect:/admin/donors";
        }

        model.addAttribute("donor", donorOpt.get());
        model.addAttribute("donations", donorService.getDonationsByDonorId(id)); // Gọi từ service
        return "admin/viewDonor";
    }

    // Gửi thông báo/yêu cầu đến người hiến máu
    @PostMapping("/request/{id}")
    public String sendRequest(@PathVariable Long id,
                              @RequestParam("message") String message,
                              RedirectAttributes redirect) {
        Optional<Donor> donorOpt = donorService.getDonorById(id);
        if (donorOpt.isPresent()) {
            donorService.sendBloodRequest(donorOpt.get(), message); // Gửi yêu cầu
            redirect.addFlashAttribute("message", "Đã gửi yêu cầu hiến máu.");
        } else {
            redirect.addFlashAttribute("message", "Không tìm thấy người hiến máu.");
        }
        return "redirect:/admin/donors";
    }

    // Danh sách yêu cầu hiến máu chờ duyệt
    @GetMapping("/pending-requests")
    public String listPendingBloodRequests(Model model) {
        model.addAttribute("requests", donorService.getPendingBloodRequests());
        return "admin/pendingRequests";
    }

    // Duyệt yêu cầu hiến máu (chuyển thành người hiến chính thức)
    @PostMapping("/approve-request/{id}")
    public String approveBloodRequest(@PathVariable Long id, RedirectAttributes redirect) {
        donorService.approveRequestToDonor(id);
        redirect.addFlashAttribute("message", "Đã duyệt thành người hiến máu.");
        return "redirect:/admin/donors/pending-requests";
    }
}
