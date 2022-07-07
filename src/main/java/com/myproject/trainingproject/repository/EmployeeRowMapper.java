package com.myproject.trainingproject.repository;

import com.myproject.trainingproject.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Employee(
                resultSet.getString("email"),
                resultSet.getString("name"),
                resultSet.getInt("age"),
                LocalDate.parse(resultSet.getString("birthDay"))
        );
    }
}
