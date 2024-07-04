package com.basic.myspringboot.controller;

import com.basic.myspringboot.exception.BusinessException;
import com.basic.myspringboot.model.user.User;
import com.basic.myspringboot.model.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {
    private final UserRepository userRepository;

    //Constructor Injection
//    public UserRestController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id) //Optional<User>
                .orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));
    }
//    public User getUser(@PathVariable Long id) {
//        Optional<User> optionalUser = userRepository.findById(id);
//        //orElseThrow(Supplier) Supplier 추상메서드 T get()
//        //1. Anonymous Inner Class
//        User existUser = optionalUser.orElseThrow(new Supplier<BusinessException>() {
//            @Override
//            public BusinessException get() {
//                return new BusinessException("User Not Found", HttpStatus.NOT_FOUND);
//            }
//        });
//        return existUser;
//    }

    @PatchMapping("/{email}/")
    public User updateUser(@PathVariable String email, @RequestBody User userDetail) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));
        user.setName(userDetail.getName());
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

}
