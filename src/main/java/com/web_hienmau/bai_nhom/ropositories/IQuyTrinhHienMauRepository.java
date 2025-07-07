package com.web_hienmau.bai_nhom.ropositories;

import com.web_hienmau.bai_nhom.model.QuyTrinhHienMau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuyTrinhHienMauRepository extends JpaRepository<QuyTrinhHienMau, Long> {
}
