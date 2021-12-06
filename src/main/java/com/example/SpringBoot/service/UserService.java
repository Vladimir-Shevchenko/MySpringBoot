package com.example.SpringBoot.service;

import com.example.SpringBoot.entity.UserEntity;
import com.example.SpringBoot.exception.UserAlreadyExistException;
import com.example.SpringBoot.exception.UserNotFoundException;
import com.example.SpringBoot.model.User;
import com.example.SpringBoot.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepo userRepo;


 public    UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
      return   userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException{
       UserEntity user = userRepo.findById(id).get();

        if (user==null){
            throw new UserNotFoundException("Нет такого пользователя");
        }
        return  User.toModel(user);
    }

    public Long delete(Long id){

     userRepo.deleteById(id);
     return id;
    }

}
