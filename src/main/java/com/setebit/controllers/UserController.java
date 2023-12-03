package com.setebit.controllers;

import com.setebit.dto.CreateUserDTO;
import com.setebit.dto.UserDTO;
import com.setebit.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid CreateUserDTO signupDTO) {
       UserDTO createdUser = userService.create(signupDTO);
       if (createdUser == null){
           return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        List< UserDTO> list = userService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
