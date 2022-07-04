package com.myproject.trainingproject.controller;

import com.myproject.trainingproject.model.Department;

import java.util.List;

public class DepartmentsUtils {

    private DepartmentsUtils(){
    }

    public static List<Department> addDepartment(Department department, List<Department> list) {
        list.add(department);
        return list;
    }

    public static List<Department> deleteDepartment(Department department, List<Department> list) {
        list.remove(department);
        return list;
    }
}
