package com.example.SpringBoot.repository;

import com.example.SpringBoot.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
UserEntity findByUsername(String username);
}



