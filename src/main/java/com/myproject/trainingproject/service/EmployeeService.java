package com.myproject.trainingproject.service;

import com.myproject.trainingproject.model.Employee;
import com.myproject.trainingproject.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeDAO;

    public EmployeeService(EmployeeRepository employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getEmployees() {
        return employeeDAO.select();
    }

    public void addEmployee(Employee employee) {
        employeeDAO.insert(employee);
    }

    public void deleteEmployee(int id) {
        employeeDAO.delete(id);
    }

    public Employee getEmployeeByID(int id) {
        return employeeDAO.selectById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Employee with id %s not found", id)));
    }

}
