package com.myproject.trainingproject.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

@Data
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true)
public class Department {

    private String name;
    Set<Employee> employees;

    public void add(Employee employee) {
        this.employees.add(employee);
    }

    public void add(List<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void remove(String name) {
        Employee employee = this.employees.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Employee does not exist"));
        this.employees.remove(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
