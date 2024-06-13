package com.example.qlsv.controllers;

import com.example.qlsv.models.AppUser;
import com.example.qlsv.models.Student;
import com.example.qlsv.service.AppUserService;
import com.example.qlsv.service.StudentService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Đánh dấu lớp này là một controller trong Spring MVC
@Controller
public class StudentController {
    @Autowired
    AppUserService appUserService; // Tự động nối kết AppUserService vào trường này

    @Autowired
    StudentService studentService; // Tự động nối kết StudentService vào trường này

    // Xử lý các yêu cầu GET tới "/student/home"
    @GetMapping("/student/home")
    public String getStudentHome(HttpSession session, Model model) {
        AppUser user = (AppUser) session.getAttribute("user"); // Lấy thông tin người dùng từ session
        if (user != null) { // Kiểm tra nếu người dùng tồn tại trong session
            Student student = studentService.findByUser(user); // Tìm sinh viên theo thông tin người dùng
            if (student != null) { // Kiểm tra nếu tìm thấy sinh viên
                model.addAttribute("student", student); // Thêm thông tin sinh viên vào model
                return "student/home"; // Trả về view của trang chủ sinh viên
            }
        }
        return "redirect:/login"; // Nếu không tìm thấy người dùng hoặc sinh viên, chuyển hướng về trang đăng nhập
    }

}
