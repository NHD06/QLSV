package com.example.qlsv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.qlsv.models.AwardsDisciplines;
import com.example.qlsv.service.AwardsService;

public class AwardController {
    
    @Autowired
    private AwardsService awardsService;

    @GetMapping("/student/awards")
    public String showAwardsPage(Model model) {
        // Lấy danh sách khen thưởng và kỷ luật từ service
        List<AwardsDisciplines> awardsDisciplines = awardsService.findAll();

        // Thêm danh sách vào model để truyền đến view
        model.addAttribute("awardsDisciplines", awardsDisciplines);

        // Trả về tên của view
        return "student/awards";
    }
}
