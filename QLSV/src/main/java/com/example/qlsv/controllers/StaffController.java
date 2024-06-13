package com.example.qlsv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.qlsv.models.AppUser;
import com.example.qlsv.models.Student;
import com.example.qlsv.service.AppUserService;
import com.example.qlsv.service.DepartmentService;
import com.example.qlsv.service.StudentService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

// Đánh dấu lớp này là một controller trong Spring MVC
@Controller
public class StaffController {
    @Autowired
    AppUserService appUserService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    StudentService studentService;
    
    // Xử lý các yêu cầu GET tới "/staff/home"
    @GetMapping("/staff/home")
    public String studentList(@RequestParam(name = "query", required = false) String query, HttpSession session, Model model) {
        AppUser user = (AppUser) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login"; // Nếu không có user trong session, chuyển hướng về trang đăng nhập
        }

        Long departmentId = user.getDepartmentId();
        if (departmentId == null) {
            return "error"; // Xử lý trường hợp departmentId không tồn tại
        }

        List<Student> students;
        if (query != null && !query.isEmpty()) {
            // Tìm sinh viên theo mã sinh viên hoặc tên và thuộc về phòng ban của user
            students = studentService.findByStudentCodeContainingOrFullnameContainingAndDepartmentId(query, query, departmentId);
        } else {
            // Lấy danh sách sinh viên theo ID phòng ban
            students = departmentService.getStudentsByDepartmentId(departmentId);
        }

        model.addAttribute("students", students);
        return "staff/home"; // Trả về view của trang chủ nhân viên
    }

    // Xử lý các yêu cầu GET tới "/getStudentDetails/{id}", trả về thông tin chi tiết của sinh viên dưới dạng JSON
    @GetMapping("/getStudentDetails/{id}")
    @ResponseBody
    public Student getStudentDetails(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id);
        return new Student(
            student.getId(),
            student.getStudentCode(),
            student.getFullname(),
            student.getEmail(),
            student.getPhoneNumber(),
            student.getAddress(),
            student.getDepartment(),
            student.getEntryDate(),
            null, // user
            student.getGender(),
            student.getStatus(),
            student.getProfileCode(),
            student.getClassCode(),
            student.getEducationLevel(),
            student.getMajor(),
            student.getCourse(),
            student.getDateOfBirth(),
            student.getTargetGroup(),
            student.getBirthPlace(),
            student.getBankName(),
            student.getAccountHolderName(),
            student.getBankAccountNumber(),
            student.getAdvisorName(),
            student.getAdvisorPhone(),
            student.getAdvisorEmail()
        );
    }

    // Xử lý các yêu cầu POST tới "/updateStudent", cập nhật thông tin sinh viên
    @PostMapping("/updateStudent")
    @ResponseBody
    public ResponseEntity<String> updateStudent(@ModelAttribute Student student) {
        try {
            Student existingStudent = studentService.getStudentById(student.getId()); // Lấy thông tin sinh viên hiện tại từ cơ sở dữ liệu
            if (existingStudent == null) { // Kiểm tra xem sinh viên có tồn tại không
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found."); // Trả về mã lỗi 404 nếu không tìm thấy sinh viên
            }
            
            // Cập nhật thông tin sinh viên với dữ liệu mới
            existingStudent.setStudentCode(student.getStudentCode());
            existingStudent.setFullname(student.getFullname());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPhoneNumber(student.getPhoneNumber());
            existingStudent.setAddress(student.getAddress());
            // Cập nhật các trường khác tương tự nếu cần
            
            studentService.save(existingStudent); // Lưu thông tin sinh viên đã cập nhật
            
            return ResponseEntity.ok("Student information updated successfully."); // Trả về thông báo thành công
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student details."); // Trả về mã lỗi 500 nếu có lỗi xảy ra
        }
    }

    // Xử lý các yêu cầu GET tới "/add", hiển thị form thêm sinh viên
    @GetMapping("/add")
    public String showAddStudentForm(@ModelAttribute("student") Student student) {
        return "add-student-form"; // Tên view của form thêm sinh viên
    }

    // Xử lý các yêu cầu POST tới "/addStudent", thêm sinh viên mới
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/staff/home"; // Chuyển hướng về trang chủ nhân viên sau khi thêm sinh viên
    }

    // Xử lý các yêu cầu POST tới "/deleteStudent/{id}", xóa sinh viên
    @PostMapping("/deleteStudent/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        try {
            // Kiểm tra xem sinh viên có tồn tại không
            Student existingStudent = studentService.getStudentById(id);
            if (existingStudent == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
            }
            
            // Xóa sinh viên từ cơ sở dữ liệu
            studentService.deleteById(id);
            
            return ResponseEntity.ok("Student deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting student.");
        }
    }
}
