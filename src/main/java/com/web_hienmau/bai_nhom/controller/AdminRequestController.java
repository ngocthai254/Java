package com.web_hienmau.bai_nhom.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web_hienmau.bai_nhom.model.BloodRequest;
import com.web_hienmau.bai_nhom.model.Donor;
import com.web_hienmau.bai_nhom.service.BloodRequestService;
import com.web_hienmau.bai_nhom.service.DonorService;

@Controller
@RequestMapping("/admin/requests")
public class AdminRequestController {

    @Autowired
    private BloodRequestService bloodRequestService;

    @Autowired
    private DonorService donorService;

    // ✅ Hiển thị danh sách các yêu cầu hiến máu
    @GetMapping("")
    public String listRequests(Model model) {
        List<BloodRequest> requests = bloodRequestService.findAll();
        model.addAttribute("requests", requests);
        return "admin/requests"; // Trỏ đến templates/admin/requests.html
    }

    // ✅ Duyệt một yêu cầu => thêm vào danh sách người hiến
    @PostMapping("/approve/{id}")
    public String approveRequest(@PathVariable Long id, RedirectAttributes redirect) {
        Optional<BloodRequest> optionalRequest = bloodRequestService.findById(id);
        if (optionalRequest.isPresent()) {
            BloodRequest request = optionalRequest.get();

            Donor donor = new Donor();
            donor.setFullName(request.getFullName());
            donor.setPhone(request.getPhone());
            donor.setGender(request.getGender());
            donor.setBloodGroup(request.getBloodGroup());
            donor.setApproved(true); // Đã duyệt
            donor.setBirthDate(LocalDate.of(2000, 1, 1)); // Giả định
            donor.setAddress("Chưa cập nhật");
            donor.setEmail("example@email.com"); // Vì BloodRequest không có email

            donorService.saveDonor(donor);

            // Cập nhật trạng thái
            request.setStatus("Đã duyệt");
            bloodRequestService.save(request);

            redirect.addFlashAttribute("message", "Đã duyệt thành công và thêm vào danh sách người hiến.");
        } else {
            redirect.addFlashAttribute("error", "Không tìm thấy yêu cầu.");
        }
        return "redirect:/admin/requests";
    }

    @GetMapping("/view/{id}")
    public String viewRequest(@PathVariable Long id, Model model, RedirectAttributes redirect) {
        Optional<BloodRequest> requestOpt = bloodRequestService.findById(id);
        if (requestOpt.isPresent()) {
            model.addAttribute("request", requestOpt.get());
            return "admin/requestDetail"; 
        } else {
            redirect.addFlashAttribute("error", "Không tìm thấy yêu cầu.");
            return "redirect:/admin/requests";
        }
    }
}
