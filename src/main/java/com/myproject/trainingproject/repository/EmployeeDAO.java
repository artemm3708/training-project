package com.myproject.trainingproject.repository;

import com.myproject.trainingproject.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAO implements DAO<Employee> {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> select() {
        var sql = """
                SELECT id, email, name, age, birthDay
                FROM employees
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public int insert(Employee employee) {
        var sql = """
                INSERT INTO employees(email, name, age, birthDay)
                VALUES (?, ?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                employee.email(), employee.name(), employee.age(), employee.birthDay()
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
                SELECT id, email, name, age, birthDay
                FROM employees
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new EmployeeRowMapper(), id)
                .stream()
                .findFirst();
    }


}
