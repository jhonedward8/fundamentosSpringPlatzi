package com.fundamentos.springboot.fundamentos.usecase;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUser {

    private final UserService userService;

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
