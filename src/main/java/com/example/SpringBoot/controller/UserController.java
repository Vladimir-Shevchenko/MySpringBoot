package com.example.SpringBoot.controller;

import com.example.SpringBoot.entity.UserEntity;
import com.example.SpringBoot.exception.UserAlreadyExistException;
import com.example.SpringBoot.exception.UserNotFoundException;
import com.example.SpringBoot.repository.UserRepo;
import com.example.SpringBoot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

UserService userService;



    @PostMapping
    public ResponseEntity registration (@RequestBody  UserEntity user){


           try{
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен!");
        }catch (UserAlreadyExistException e){return  ResponseEntity.badRequest().body(e.getMessage());}

    }

    @GetMapping
    public ResponseEntity getOneUsers(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e){return ResponseEntity.badRequest().body(e.getMessage());}
        catch (Exception e){return ResponseEntity.badRequest().body("Произошла ошибка");}
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }catch (Exception e){return ResponseEntity.badRequest().body("Произошла ошибка");}
    }
}
