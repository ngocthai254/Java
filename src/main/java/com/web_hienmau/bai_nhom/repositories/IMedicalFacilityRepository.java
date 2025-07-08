package com.web_hienmau.bai_nhom.ropositories;
import com.web_hienmau.bai_nhom.model.MedicalFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicalFacilityRepository extends JpaRepository<MedicalFacility, Long> {
}
