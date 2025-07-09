package com.web_hienmau.bai_nhom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web_hienmau.bai_nhom.model.Blog;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
}