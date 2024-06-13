package com.example.qlsv.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.qlsv.models.Student;
import com.example.qlsv.service.AppUserService;
import com.example.qlsv.service.AwardsService;
import com.example.qlsv.service.DepartmentService;
import com.example.qlsv.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DepartmentController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    StudentService studentService;

    @Autowired
    AwardsService awardsService;

    @GetMapping("/department/home")
    public String departmentHome(@RequestParam(name = "query", required = false) String query, HttpSession session, Model model) {
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
            students = studentService.findByStudentCodeContainingOrFullnameContainingAndDepartmentId(query, query, departmentId);
        } else {
            students = departmentService.getStudentsByDepartmentId(departmentId);
        }

        model.addAttribute("students", students);
        return "department/home";
    }

    @GetMapping("/getStudent/{id}")
    @ResponseBody
    public Student departmentStudent(@PathVariable("id") Long id) {
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

    // Hiển thị form thêm mới khen thưởng/kỷ luật
    @GetMapping("/department/add")
    public String showAddForm(ModelMap model) {
        AwardsDisciplines award = new AwardsDisciplines();
        model.addAttribute("awardsDisciplines", award);
        model.addAttribute("ACTION", "/department/add");
        model.addAttribute("students", studentService.findAll()); // Thêm danh sách sinh viên vào model
        return "department/add";
    }

    // Xử lý form thêm mới khen thưởng/kỷ luật
    @PostMapping("/department/add")
    public String saveAwardsDisciplines(@ModelAttribute("awardsDisciplines") AwardsDisciplines awardsDisciplines) {
        awardsService.save(awardsDisciplines);
        return "redirect:/department/list";
    }

    // Hiển thị danh sách khen thưởng/kỷ luật
    @GetMapping("/department/list")
    public String listAwardsDisciplines(Model model) {
        List<AwardsDisciplines> list = awardsService.findAll();
        model.addAttribute("awardsDisciplines", list);
        return "department/list";
    }

    // Hiển thị form sửa khen thưởng/kỷ luật
    @GetMapping("/department/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<AwardsDisciplines> awardsDisciplinesOpt = awardsService.findById(id);
        if (awardsDisciplinesOpt.isPresent()) {
            AwardsDisciplines awardsDisciplines = awardsDisciplinesOpt.get();
            model.addAttribute("awardsDisciplines", awardsDisciplines);
            model.addAttribute("students", studentService.findAll()); // Gửi danh sách sinh viên đến view
            return "department/edit";
        } else {
            return "redirect:/department/list"; // Chuyển hướng nếu ID không tìm thấy
        }
    }

    // Xử lý form sửa khen thưởng/kỷ luật
    @PostMapping("/department/edit/{id}")
    public String updateAwardsDisciplines(@PathVariable("id") Long id, @ModelAttribute AwardsDisciplines awardsDisciplines) {
        awardsDisciplines.setId(id);
        awardsService.save(awardsDisciplines);
        return "redirect:/department/list";
    }

    // Xử lý yêu cầu xóa khen thưởng/kỷ luật
    // Handle request to delete an award/discipline
    @PostMapping("/department/delete/{id}")
    public String deleteAwardsDisciplines(@PathVariable("id") Long id) {
        awardsService.deleteById(id);
        return "redirect:/department/list";
    }

}
