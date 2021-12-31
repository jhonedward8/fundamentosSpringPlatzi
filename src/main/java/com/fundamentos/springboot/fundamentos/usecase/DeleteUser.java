package com.fundamentos.springboot.fundamentos.usecase;

import com.fundamentos.springboot.fundamentos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteUser {

    private final UserService userService;

    public void remove(Long id) {
        userService.delete(id);
    }
}
