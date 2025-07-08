package com.web_hienmau.bai_nhom.controller;

import com.web_hienmau.bai_nhom.service.MauDaHienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class TraCuuTruyenMauController {

    private final MauDaHienService mauDaHienService;

    @Autowired
    public TraCuuTruyenMauController(MauDaHienService mauDaHienService) {
        this.mauDaHienService = mauDaHienService;
    }

    private static final Map<String, List<String>> BLOOD_COMPATIBILITY_FULL = new HashMap<>();

    private static final Map<String, List<String>> RBC_COMPATIBILITY = new HashMap<>();

    static {
        BLOOD_COMPATIBILITY_FULL.put("O-", List.of("O-"));
        BLOOD_COMPATIBILITY_FULL.put("O+", List.of("O+", "O-"));
        BLOOD_COMPATIBILITY_FULL.put("A-", List.of("A-", "O-"));
        BLOOD_COMPATIBILITY_FULL.put("A+", List.of("A+", "A-", "O+", "O-"));
        BLOOD_COMPATIBILITY_FULL.put("B-", List.of("B-", "O-"));
        BLOOD_COMPATIBILITY_FULL.put("B+", List.of("B+", "B-", "O+", "O-"));
        BLOOD_COMPATIBILITY_FULL.put("AB-", List.of("AB-", "A-", "B-", "O-"));
        BLOOD_COMPATIBILITY_FULL.put("AB+", List.of("AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"));

        RBC_COMPATIBILITY.put("O", List.of("O"));
        RBC_COMPATIBILITY.put("A", List.of("A", "O"));
        RBC_COMPATIBILITY.put("B", List.of("B", "O"));
        RBC_COMPATIBILITY.put("AB", List.of("A", "B", "AB", "O"));
    }

    private List<String> getCompatiblePlasmaDonor(String recipientGroup) {
        return switch (recipientGroup.toUpperCase()) {
            case "AB" -> List.of("AB");
            case "A" -> List.of("A", "AB");
            case "B" -> List.of("B", "AB");
            case "O" -> List.of("O", "A", "B", "AB");
            default -> List.of(); 
        };
    }

    private List<String> getCompatibleByMap(String group, Map<String, List<String>> map) {
        return map.getOrDefault(group.toUpperCase(), new ArrayList<>());
    }

    @GetMapping("/user/tra-cuu-truyen-mau")
    public String showForm() {
        return "user/traCuuTruyenMauForm"; 
    }

    @PostMapping("/user/tra-cuu-truyen-mau")
    public String processForm(@RequestParam("bloodGroup") String bloodGroup, Model model) {
        List<String> fullCompatible = getCompatibleByMap(bloodGroup, BLOOD_COMPATIBILITY_FULL);

        String abo = bloodGroup.toUpperCase().replaceAll("[+-]", ""); 
        List<String> rbcCompatible = getCompatibleByMap(abo, RBC_COMPATIBILITY);

        List<String> plasmaCompatible = getCompatiblePlasmaDonor(abo);

        Map<String, Long> tongLuongTheoNhomMau = mauDaHienService.thongKeTheoMap();

        Map<String, Long> fullStats = new LinkedHashMap<>();
        for (String group : fullCompatible) {
            fullStats.put(group, tongLuongTheoNhomMau.getOrDefault(group, 0L));
        }

        model.addAttribute("bloodGroup", bloodGroup);
        model.addAttribute("fullCompatible", fullCompatible);
        model.addAttribute("fullStats", fullStats);
        model.addAttribute("rbcCompatible", rbcCompatible);
        model.addAttribute("plasmaCompatible", plasmaCompatible);

        return "user/ketQuaTraCuuTruyenMau";
    }
}
