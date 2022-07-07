package com.myproject.trainingproject.service;

import com.myproject.trainingproject.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService{

    public List<Department> addDepartment(Department department, List<Department> list) {
        list.add(department);
        return list;
    }

    public List<Department> deleteDepartment(Department department, List<Department> list) {
        list.remove(department);
        return list;
    }
}
