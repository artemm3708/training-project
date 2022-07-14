package com.myproject.trainingproject.controller;

import com.myproject.trainingproject.service.DepartmentService;
import com.myproject.trainingproject.model.Department;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import static lombok.AccessLevel.PRIVATE;

@Controller
@RequestMapping("/departments")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DepartmentController {

    DepartmentService departmentService;

    @GetMapping()
    public String departments(Model model) {
        model.addAttribute("departments", departmentService.getDepartments());
        return "departments/departments_page";
    }

    @GetMapping("/createDepartment")
    public String createDepartment(@ModelAttribute Department department) {
        departmentService.addDepartment(department);
        return "departments/createDepartment_page";
    }

    @DeleteMapping("/deleteDepartment")
    public String deleteDepartment(@ModelAttribute Department department) {
        departmentService.deleteDepartment(department);
        return "redirect:/employees";
    }
}
