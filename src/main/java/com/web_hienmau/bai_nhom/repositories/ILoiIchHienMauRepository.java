package com.web_hienmau.bai_nhom.repositories;

import com.web_hienmau.bai_nhom.model.LoiIchHienMau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoiIchHienMauRepository extends JpaRepository<LoiIchHienMau, Long> {
}
