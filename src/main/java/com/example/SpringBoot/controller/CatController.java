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


@RestController
@RequestMapping("/cat")
public class CatController {





    @PostMapping("/")
    public ResponseEntity registration (){


        try{

            return ResponseEntity.ok("Meow!");
        }catch (Exception e){return  ResponseEntity.badRequest().body(e.getMessage());}

    }

    @GetMapping
    public ResponseEntity getOneUsers(@RequestParam Long id){
        try {
            return ResponseEntity.ok("get meow ");
        }catch (Exception e){return ResponseEntity.badRequest().body("Произошла ошибка");}
    }


}
