package com.myproject.trainingproject.controller;

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

    @GetMapping("/departments")
    public String departments(Model model) {
        model.addAttribute("departments", departments);
        return "departments_page";
    }

    @GetMapping("/createDepartment")
    public String createDepartment(@ModelAttribute Department department) {
        DepartmentsUtils.addDepartment(department, departments);
        return "createDepartment_page";
    }

    @PostMapping("/deleteDepartment")
    public String deleteDepartment(@ModelAttribute Department department) {
        DepartmentsUtils.deleteDepartment(department, departments);
        return "redirect:/departments";
    }
}
