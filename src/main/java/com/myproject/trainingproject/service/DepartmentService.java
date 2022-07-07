package com.myproject.trainingproject.service;

import com.myproject.trainingproject.model.Department;
import com.myproject.trainingproject.repository.DepartmentDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentService {

    private final DepartmentDAO departmentDAO;

    public DepartmentService(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public List<Department> getDepartments() {
        return departmentDAO.select();
    }

    public void addDepartment(Department department) {
        departmentDAO.insert(department);
    }

    public void deleteDepartment(int id) {
        departmentDAO.delete(id);
    }

    public Department getDepartmentByID(int id) {
        return departmentDAO.selectById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Department with id %s not found", id)));
    }
}
