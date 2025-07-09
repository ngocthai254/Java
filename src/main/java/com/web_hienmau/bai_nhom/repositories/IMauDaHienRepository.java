package com.web_hienmau.bai_nhom.repositories;

import com.web_hienmau.bai_nhom.model.MauDaHien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IMauDaHienRepository extends JpaRepository<MauDaHien, Long> {

    @Query("SELECT m.bloodGroup, SUM(m.quantity) FROM MauDaHien m GROUP BY m.bloodGroup")
    List<Object[]> getTongLuongTheoNhomMau();
}
