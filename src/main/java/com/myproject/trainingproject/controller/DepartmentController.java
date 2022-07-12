package com.myproject.trainingproject.controller;

import com.myproject.trainingproject.service.DepartmentService;
import com.myproject.trainingproject.model.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public String departments(Model model) {
        model.addAttribute("departments");
        return "departments_page";
    }

    @GetMapping("/createDepartment")
    public String createDepartment(@ModelAttribute Department department) {
        departmentService.addDepartment(department);
        return "createDepartment_page";
    }

    @PostMapping("/deleteDepartment")
    public void deleteDepartment(@ModelAttribute Integer id) {
        departmentService.deleteDepartment(id);
    }
}
