package com.web_hienmau.bai_nhom.ropositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web_hienmau.bai_nhom.model.BloodRequest;

public interface IBloodRequestRepository extends JpaRepository<BloodRequest, Long> {
    // Không cần viết gì thêm nếu dùng phương thức mặc định
}