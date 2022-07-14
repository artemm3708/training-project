package com.myproject.trainingproject.service;

import com.myproject.trainingproject.model.Employee;
import com.myproject.trainingproject.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Employee getEmployeeByID(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Employee with id %s not found", id)));
    }

}
