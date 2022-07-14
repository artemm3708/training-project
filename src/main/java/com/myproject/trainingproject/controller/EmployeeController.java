package com.myproject.trainingproject.controller;

import com.myproject.trainingproject.model.Employee;
import com.myproject.trainingproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@Controller
@RequestMapping("/employees")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmployeeController {
    EmployeeService employeeService;

    @GetMapping()
    public String employees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees/employees_page";
    }

    @GetMapping("/createEmployee")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "employees/createEmployee_page";
    }

    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(@ModelAttribute Employee employee) {
        employeeService.deleteEmployee(employee);
        return "redirect:/employees";
    }
}
