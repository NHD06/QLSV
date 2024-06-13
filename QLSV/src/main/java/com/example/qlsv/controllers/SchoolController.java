package com.example.qlsv.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.qlsv.models.AppUser;
import com.example.qlsv.models.AwardsDisciplines;
import com.example.qlsv.models.Department;
import com.example.qlsv.models.Student;
import com.example.qlsv.service.AppUserService;
import com.example.qlsv.service.AwardsService;
import com.example.qlsv.service.DepartmentService;
import com.example.qlsv.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SchoolController {

    @Autowired
    StudentService studentService;

    @Autowired
    AppUserService appUserService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    AwardsService awardsService;

    @GetMapping("/school/home")
    public String schoolHome(@RequestParam(name = "query", required = false) String query, HttpSession session, Model model) {
        AppUser user = (AppUser) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login"; // Nếu không có user trong session, chuyển hướng về trang đăng nhập
        }
        // Lấy ra tất cả sinh viên của trường
        List<Student> students = studentService.findAll();
        
        // Nhóm sinh viên theo khoa
        Map<Department, List<Student>> studentsByDepartment = students.stream()
            .collect(Collectors.groupingBy(Student::getDepartment));

        model.addAttribute("studentsByDepartment", studentsByDepartment);
        return "school/home";
    }



    @GetMapping("/getStudentSchool/{id}")
    @ResponseBody
    public Student schoolStudent(@PathVariable("id") Long id) {
        // Lấy thông tin sinh viên dựa trên ID
        Student student = studentService.getStudentById(id);
        return student;
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable("id") Long id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    // Hiển thị form thêm mới khen thưởng/kỷ luật
    @GetMapping("/school/add")
    public String showAddFormAward(ModelMap model) {
        AwardsDisciplines award = new AwardsDisciplines();
        model.addAttribute("awardsDisciplines", award);
        model.addAttribute("ACTION", "/department/add");
        model.addAttribute("students", studentService.findAll()); // Thêm danh sách sinh viên vào model
        return "school/add";
    }

    // Xử lý form thêm mới khen thưởng/kỷ luật
    @PostMapping("/school/add")
    public String saveAwards(@ModelAttribute("awardsDisciplines") AwardsDisciplines awardsDisciplines) {
        awardsService.save(awardsDisciplines);
        return "redirect:/school/list";
    }

    // Hiển thị danh sách khen thưởng/kỷ luật
    @GetMapping("/school/list")
    public String listAwards(Model model) {
        List<AwardsDisciplines> list = awardsService.findAll();
        model.addAttribute("awardsDisciplines", list);
        return "school/list";
    }

    // Hiển thị form sửa khen thưởng/kỷ luật
    @GetMapping("/school/edit/{id}")
    public String showEditFormAward(@PathVariable("id") Long id, Model model) {
        Optional<AwardsDisciplines> awardsDisciplinesOpt = awardsService.findById(id);
        if (awardsDisciplinesOpt.isPresent()) {
            AwardsDisciplines awardsDisciplines = awardsDisciplinesOpt.get();
            model.addAttribute("awardsDisciplines", awardsDisciplines);
            model.addAttribute("students", studentService.findAll()); // Gửi danh sách sinh viên đến view
            return "school/edit";
        } else {
            return "redirect:/school/list"; // Chuyển hướng nếu ID không tìm thấy
        }
    }

    // Xử lý form sửa khen thưởng/kỷ luật
    @PostMapping("/school/edit/{id}")
    public String updateAward(@PathVariable("id") Long id, @ModelAttribute AwardsDisciplines awardsDisciplines) {
        awardsDisciplines.setId(id);
        awardsService.save(awardsDisciplines);
        return "redirect:/school/list";
    }

    // Xử lý yêu cầu xóa khen thưởng/kỷ luật
    // Handle request to delete an award/discipline
    @PostMapping("/school/delete/{id}")
    public String deleteAward(@PathVariable("id") Long id) {
        awardsService.deleteById(id);
        return "redirect:/department/list";
    }
}   
