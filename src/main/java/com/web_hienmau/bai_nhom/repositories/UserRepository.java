package com.web_hienmau.bai_nhom.repositories;

import com.web_hienmau.bai_nhom.model.Userclass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userclass, String> {
    Userclass findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsBySoDienThoai(String soDienThoai);
}
