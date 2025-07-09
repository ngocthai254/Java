package com.web_hienmau.bai_nhom.controller;

import com.web_hienmau.bai_nhom.model.Blog;
import com.web_hienmau.bai_nhom.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user/blogs")
public class UserBlogController {

    private final BlogService blogService;

    @Autowired
    public UserBlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public String listUserBlogs(Model model) {
        List<Blog> blogs = blogService.getAllBlogs();
        model.addAttribute("blogs", blogs);
        return "user/blogs"; 
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "user/addBlogForm"; 
    }

    @PostMapping("/add")
    public String addBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        try {
            blogService.saveBlog(blog);
            redirectAttributes.addFlashAttribute("message", "Gửi bài viết thành công! Chờ duyệt.");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Lỗi khi gửi blog: " + e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        return "redirect:/user/blogs";
    }
}
