package com.web_hienmau.bai_nhom.repositories;

import com.web_hienmau.bai_nhom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}