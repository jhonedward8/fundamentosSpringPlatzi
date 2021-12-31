package com.fundamentos.springboot.fundamentos.usecase;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetUserImpl implements GetUser{
    private final UserService userService;

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @Override
    public List<User> getAllPagination(int page, int size) {
        return userService.getAllPaginationUsers(page, size);
    }
}
