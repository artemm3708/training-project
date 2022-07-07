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

    private static List<Department> departments = new ArrayList<>();
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public String departments(Model model) {
        model.addAttribute("departments", departments);
        return "departments_page";
    }

    @GetMapping("/createDepartment")
    public String createDepartment(@ModelAttribute Department department) {
        departmentService.addDepartment(department, departments);
        return "createDepartment_page";
    }

    @PostMapping("/deleteDepartment")
    public String deleteDepartment(@ModelAttribute Department department) {
        departmentService.deleteDepartment(department, departments);
        return "redirect:/departments";
    }
}
