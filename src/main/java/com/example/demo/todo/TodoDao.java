package com.example.demo.todo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends CrudRepository<Todo,Long> {
    public Todo findById(long id);
}
