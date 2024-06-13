package com.example.qlsv.controllers;

// Import các lớp và gói cần thiết
import com.example.qlsv.models.AppUser;
import com.example.qlsv.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

// Đánh dấu lớp này là một controller trong Spring MVC
@Controller
public class LoginController {

    // Tự động nối kết AppUserService vào trường này
    @Autowired
    private AppUserService userService;

    // Xử lý các yêu cầu GET tới "/login", trả về trang đăng nhập
    @GetMapping("/login")
    public String login() {
        return "login/login"; // Trả về tên của trang đăng nhập
    }

    // Xử lý các yêu cầu POST tới "/login"
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        // Kiểm tra thông tin đăng nhập của người dùng
        AppUser user = userService.checkLogin(username, password);

        if (user != null) {
            // Nếu thông tin đăng nhập đúng, lưu thông tin người dùng vào session
            session.setAttribute("user", user);
            return determineTargetUrl(user); // Chuyển hướng tới trang tương ứng dựa trên vai trò của người dùng
        } else {
            // Nếu thông tin đăng nhập sai, thêm thông báo lỗi vào model
            model.addAttribute("error", "Invalid username or password.");
            return "login/login"; // Trả về trang đăng nhập với thông báo lỗi
        }
    }

    // Xác định URL chuyển hướng dựa trên vai trò của người dùng
    private String determineTargetUrl(AppUser user) {
        String url = "";
        if (user.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_STAFF"))) {
            url = "redirect:/staff/home";
        } else if (user.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_DEPARTMENT_HEAD"))) {
            url = "redirect:/department/home";
        } else if (user.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_SCHOOL_HEAD"))) {
            url = "redirect:/school/home";
        } else if (user.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_STUDENT"))) {
            url = "redirect:/student/home";
        }
        System.out.println("Redirecting to: " + url); // In ra URL chuyển hướng
        return url; // Trả về URL chuyển hướng
    }
    
    // Xử lý các yêu cầu GET tới "/logout", đăng xuất người dùng
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user"); // Xóa thông tin người dùng khỏi session
        return "login/login"; // Trả về trang đăng nhập
    }
}
