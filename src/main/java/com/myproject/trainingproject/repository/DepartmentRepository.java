package com.myproject.trainingproject.repository;

import com.myproject.trainingproject.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class DepartmentRepository implements Repository<Department> {

    private final JdbcTemplate jdbcTemplate;

    public DepartmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Department> select() {
        var sql = """
                SELECT id, name
                FROM departments
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new DepartmentRowMapper());
    }

    @Override
    public int insert(Department department) {
        var sql = """
                INSERT INTO departments(name)
                VALUES (?);
                 """;
        return jdbcTemplate.update(
                sql,
                department.getName()
        );
    }

    @Override
    public int delete(int id) {
        var sql = """
                DELETE FROM departments 
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Department> selectById(int id) {
        var sql = """
                SELECT id, name
                FROM departments
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new DepartmentRowMapper())
                .stream()
                .findFirst();
    }
}
