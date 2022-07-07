package com.myproject.trainingproject.controller;

import com.myproject.trainingproject.model.Employee;
import com.myproject.trainingproject.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees_page";
    }

    @GetMapping("/createEmployee")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "createEmployee_page";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
