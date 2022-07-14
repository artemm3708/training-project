package com.myproject.trainingproject.service;

import com.myproject.trainingproject.model.Department;
import com.myproject.trainingproject.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    public Department getDepartmentByID(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Department with id %s not found", id)));
    }
}
