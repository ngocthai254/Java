package com.web_hienmau.bai_nhom.controller;

import com.web_hienmau.bai_nhom.model.User;
import com.web_hienmau.bai_nhom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/users") 
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String userManagement(Model model, @RequestParam(value = "search", required = false) String searchTerm) {
        List<User> users;
        if (searchTerm != null && !searchTerm.isEmpty()) {
            users = userService.searchUsers(searchTerm);
        } else {
            users = userService.getAllUsers();
        }
        model.addAttribute("users", users);
        model.addAttribute("searchTerm", searchTerm);
        return "admin/user_management";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/add_user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        user.setStatus("Hoạt động"); 
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "Người dùng đã được thêm thành công!");
        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "admin/edit_user";
        } else {
            return "redirect:/admin/users"; 
        }
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "Thông tin người dùng đã được cập nhật!");
        return "redirect:/admin/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("message", "Người dùng đã được xóa!");
        return "redirect:/admin/users";
    }
}