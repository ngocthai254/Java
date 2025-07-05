package com.web_hienmau.bai_nhom.controller;

import com.web_hienmau.bai_nhom.model.Blog;
import com.web_hienmau.bai_nhom.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/blogs")
public class AdminBlogController {

    private final BlogService blogService;

    @Autowired
    public AdminBlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public String listBlogs(Model model) {
        List<Blog> blogs = blogService.getAllBlogs();
        model.addAttribute("blogs", blogs);
        return "admin/blogs"; // view hiển thị danh sách blog
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "admin/addBlogForm";
    }

    @PostMapping("/add")
    public String addBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        try {
            blogService.saveBlog(blog);
            redirectAttributes.addFlashAttribute("message", "Thêm blog thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Lỗi khi thêm blog: " + e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            blogService.deleteBlog(id);
            redirectAttributes.addFlashAttribute("message", "Xóa blog thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Lỗi khi xóa blog: " + e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Blog> blog = blogService.getBlogById(id);
        if (blog.isPresent()) {
            model.addAttribute("blog", blog.get());
            return "admin/editBlogForm";
        } else {
            redirectAttributes.addFlashAttribute("message", "Không tìm thấy blog!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/admin/blogs";
        }
    }

    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        try {
            blogService.saveBlog(blog);
            redirectAttributes.addFlashAttribute("message", "Cập nhật blog thành công!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Lỗi khi cập nhật blog: " + e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        return "redirect:/admin/blogs";
    }
}
