package com.web_hienmau.bai_nhom.controller;

import com.web_hienmau.bai_nhom.service.QuyTrinhHienMauService;
import com.web_hienmau.bai_nhom.service.ThongTinNhomMauService;
import com.web_hienmau.bai_nhom.service.LoiIchHienMauService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private ThongTinNhomMauService nhomMauService;

    @Autowired
    private QuyTrinhHienMauService quyTrinhService;

    @Autowired
    private LoiIchHienMauService loiIchHienMauService; 

    @GetMapping("/index")
    public String hienThiTrangChu(Model model) {
        model.addAttribute("dsNhomMau", nhomMauService.getAll());
        model.addAttribute("danhSachBuoc", quyTrinhService.getAllSteps());
        model.addAttribute("danhSachLoiIch", loiIchHienMauService.getAll()); 
        return "index";
    }
}