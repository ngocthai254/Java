package com.web_hienmau.bai_nhom.service;

import com.web_hienmau.bai_nhom.model.MauDaHien;
import com.web_hienmau.bai_nhom.repositories.IMauDaHienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MauDaHienService {

    private final IMauDaHienRepository repository;

    @Autowired
    public MauDaHienService(IMauDaHienRepository repository) {
        this.repository = repository;
    }
    public List<MauDaHien> getAll() {
        return repository.findAll();
    }
    public void save(MauDaHien mauDaHien) {
        repository.save(mauDaHien);
    }


    public List<Map<String, Object>> thongKeTheoNhomMau() {
        List<Object[]> rawData = repository.getTongLuongTheoNhomMau();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : rawData) {
            String bloodGroup = (String) row[0];
            Long totalMl = ((Number) row[1]).longValue();
            double totalLit = totalMl / 1000.0;

            Map<String, Object> map = new HashMap<>();
            map.put("bloodGroup", bloodGroup);
            map.put("totalMl", totalMl);
            map.put("totalLit", totalLit);
            result.add(map);
        }

        return result;
    }
    public Map<String, Long> thongKeTheoMap() {
        List<Object[]> rawData = repository.getTongLuongTheoNhomMau();
        Map<String, Long> result = new HashMap<>();

        for (Object[] row : rawData) {
            String bloodGroup = (String) row[0];
            Long totalMl = ((Number) row[1]).longValue();
            result.put(bloodGroup, totalMl);
        }
        return result;
    }

}
