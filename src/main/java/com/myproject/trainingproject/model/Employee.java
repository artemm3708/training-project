package com.myproject.trainingproject.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

public record Employee(String email,
                       String firstName,
                       String lastName,
                       Integer age,
                       LocalDate birthDay) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return email.equals(employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
