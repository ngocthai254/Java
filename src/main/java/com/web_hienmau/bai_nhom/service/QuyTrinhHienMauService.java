package com.web_hienmau.bai_nhom.service;

import com.web_hienmau.bai_nhom.model.QuyTrinhHienMau;
import com.web_hienmau.bai_nhom.repositories.IQuyTrinhHienMauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuyTrinhHienMauService {

    @Autowired
    private IQuyTrinhHienMauRepository repository;

    public List<QuyTrinhHienMau> getAllSteps() {
        return repository.findAll();
    }
}
