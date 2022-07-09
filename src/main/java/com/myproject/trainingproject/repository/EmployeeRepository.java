package com.myproject.trainingproject.repository;

import com.myproject.trainingproject.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class EmployeeRepository implements Repository<Employee> {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> select() {
        var sql = """
                SELECT id, email, first_name, last_name, age, "birthDay"
                FROM employees
                 """;
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public int insert(Employee employee) {
        var sql = """
                INSERT INTO employees(email, first_name, last_name, age, "birthDay")
                VALUES (?, ?, ?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                employee.email(), employee.firstName(), employee.lastName(), employee.age(), employee.birthDay()
        );
    }

    @Override
    public int delete(int id) {
        var sql = """
                DELETE FROM employees   
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Employee> selectById(int id) {
        var sql = """
                SELECT id, email, first_name, last_name, age, "birthDay"
                FROM employees
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new EmployeeRowMapper(), id)
                .stream()
                .findFirst();
    }


}
