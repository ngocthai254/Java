package com.web_hienmau.bai_nhom.service;

import com.web_hienmau.bai_nhom.model.LoiIchHienMau;
import com.web_hienmau.bai_nhom.ropositories.ILoiIchHienMauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoiIchHienMauService {

    @Autowired
    private ILoiIchHienMauRepository repository;

    public List<LoiIchHienMau> getAll() {
        return repository.findAll();
    }
}
