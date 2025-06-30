package com.baitaplon.blooddonationsystem.repository;
import com.baitaplon.blooddonationsystem.model.BloodUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface BloodUnitRepository extends JpaRepository<BloodUnit, Long> {
    List<BloodUnit> findByBloodTypeAndAvailableTrue(String bloodType);
    List<BloodUnit> findByBloodTypeAndComponentAndAvailableTrue(String bloodType, String component);
}

