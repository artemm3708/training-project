package com.myproject.trainingproject.controller;

import com.myproject.trainingproject.model.Employee;
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

    private static List<Employee> addEmployee(Employee employee) {
        employees.add(employee);
        return employees;
    }

    @GetMapping("/employees")
    public String employees(Model model) {
        model.addAttribute("employees", employees);
        return "employees_page";
    }

    @PostMapping("createEmployee")
    public String createEmployee(@ModelAttribute Employee employee) {
        addEmployee(employee);
        return "redirect:/employees";
    }
}
