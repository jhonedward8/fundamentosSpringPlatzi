package com.fundamentos.springboot.fundamentos.usecase;

import com.fundamentos.springboot.fundamentos.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GetUser {
    List<User> getAll();

    List<User> getAllPagination(int page, int size);
}
