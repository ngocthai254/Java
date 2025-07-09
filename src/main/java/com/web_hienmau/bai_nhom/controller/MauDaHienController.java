package com.web_hienmau.bai_nhom.controller;

import com.web_hienmau.bai_nhom.model.MauDaHien;
import com.web_hienmau.bai_nhom.service.MauDaHienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MauDaHienController {

    private final MauDaHienService service;

    @Autowired
    public MauDaHienController(MauDaHienService service) {
        this.service = service;
    }

    @GetMapping("/admin/mau-da-hien/thong-ke")
    public String hienThiThongKe(Model model) {
        model.addAttribute("thongKe", service.thongKeTheoNhomMau());
        return "admin/thongKeMauDaHien";
    }

    @GetMapping("/admin/mau-da-hien")
    public String hienThiDanhSach(Model model) {
        List<MauDaHien> danhSach = service.getAll();
        model.addAttribute("danhSach", danhSach);
        return "admin/danhSachMauDaHien";
    }
    @GetMapping("/admin/mau-da-hien/add")
    public String showAddForm(Model model) {
        model.addAttribute("mauDaHien", new MauDaHien());
        return "admin/addMauDaHienForm";
    }

    @PostMapping("/admin/mau-da-hien/add")
    public String saveMauDaHien(@ModelAttribute("mauDaHien") MauDaHien mauDaHien) {
        service.save(mauDaHien);
        return "redirect:/admin/mau-da-hien";
    }

}
