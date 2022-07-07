package com.myproject.trainingproject.service;

import com.myproject.trainingproject.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> addEmployee(Employee employee, List<Employee> list) {
        list.add(employee);
        return list;
    }

    public List<Employee> deleteEmployee(Employee employee, List<Employee> list) {
        list.remove(employee);
        return list;
    }
}
