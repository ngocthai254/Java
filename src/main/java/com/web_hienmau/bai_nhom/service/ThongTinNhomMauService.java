package com.web_hienmau.bai_nhom.service;

import com.web_hienmau.bai_nhom.model.ThongTinNhomMau;
import com.web_hienmau.bai_nhom.repositories.IThongTinNhomMauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThongTinNhomMauService {
    @Autowired
    private IThongTinNhomMauRepository repository;

    public List<ThongTinNhomMau> getAll() {
        return repository.findAll();
    }
}
