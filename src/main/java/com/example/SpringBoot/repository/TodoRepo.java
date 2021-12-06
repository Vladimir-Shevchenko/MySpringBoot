package com.example.SpringBoot.repository;

import com.example.SpringBoot.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;


public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
