package com.web_hienmau.bai_nhom.ropositories;

import com.web_hienmau.bai_nhom.model.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBloodRequestRepository extends JpaRepository<BloodRequest, Long> {
    // Không cần viết gì thêm nếu dùng phương thức mặc định
}