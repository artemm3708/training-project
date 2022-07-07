package com.myproject.trainingproject.repository;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    List<T> select();
    int insert(T val);
    int delete(int id);
    Optional<T> selectById(int id);
}
