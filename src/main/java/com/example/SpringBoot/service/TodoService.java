package com.example.SpringBoot.service;

import com.example.SpringBoot.entity.TodoEntity;
import com.example.SpringBoot.entity.UserEntity;
import com.example.SpringBoot.model.Todo;
import com.example.SpringBoot.repository.TodoRepo;
import com.example.SpringBoot.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoService {

    TodoRepo todoRepo;
    UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){

        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);

        return Todo.toModel(todoRepo.save(todo));
    }



    public Todo comleteTodo(Long id){

        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());

         return  Todo.toModel(todoRepo.save(todo));
    }
}
