package com.web_hienmau.bai_nhom.service;



import com.web_hienmau.bai_nhom.model.Blog;
import com.web_hienmau.bai_nhom.repositories.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final IBlogRepository blogRepository;

    @Autowired
    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
