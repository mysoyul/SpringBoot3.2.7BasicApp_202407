package com.basic.myspringboot.controller;

import com.basic.myspringboot.model.customer.CustomerRepository;
import com.basic.myspringboot.model.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRestController {
    private final UserRepository userRepository;

    //Constructor Injection
//    public UserRestController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }



}
