package com.myproject.trainingproject.controller;

import com.myproject.trainingproject.model.Department;
import com.myproject.trainingproject.model.Employee;
import com.myproject.trainingproject.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    private static List<Employee> employees = new ArrayList<>();
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String employees(Model model) {
        model.addAttribute("employees", employees);
        return "employees_page";
    }

    @GetMapping("createEmployee")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee, employees);
        return "createEmployee_page";
    }

    @PostMapping("/deleteDepartment")
    public String deleteDepartment(@ModelAttribute Employee employee) {
        employeeService.deleteEmployee(employee, employees);
        return "redirect:/departments";
    }
}
