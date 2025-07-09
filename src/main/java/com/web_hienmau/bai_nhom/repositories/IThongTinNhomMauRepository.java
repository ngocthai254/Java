package com.web_hienmau.bai_nhom.repositories;

import com.web_hienmau.bai_nhom.model.ThongTinNhomMau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IThongTinNhomMauRepository extends JpaRepository<ThongTinNhomMau, Long> {
}
